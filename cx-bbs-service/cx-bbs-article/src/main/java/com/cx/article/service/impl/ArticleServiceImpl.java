package com.cx.article.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleContentMapper;
import com.cx.article.mapper.ArticleMapper;
import com.cx.article.mapper.QuestionMapper;
import com.cx.article.mapper.SensitiveMapper;
import com.cx.article.service.ArticleService;
import com.cx.common.aliyun.GreenTextScan;
import com.cx.common.constants.ArticleConstants;
import com.cx.common.constants.BehaviorConstants;
import com.cx.common.redis.CacheService;
import com.cx.feign.client.UserClient;
import com.cx.model.article.ArticleInfoDto;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.ArticleDto;
import com.cx.model.article.dtos.RecommendDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.pojos.ArticleContent;
import com.cx.model.article.pojos.Sensitive;
import com.cx.model.article.vo.FollowVO;
import com.cx.model.article.vo.HotArticleVo;
import com.cx.model.article.vo.RecommendVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.mess.ArticleVisitStreamMess;
import com.cx.model.user.User;
import com.cx.model.user.vo.UserVO;
import com.cx.utils.common.SensitiveWordUtil;
import com.cx.utils.thread.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    // 单页最大的数字
    private final static short MAX_PAGE_SIZE = 50;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Resource
    private UserClient userClient;

    @Autowired
    private GreenTextScan greenTextScan;

    /**
     * 根据参数加载文章列表
     *
     * @param loadtype 1为加载  2为加载
     * @param dto
     * @return
     */
    @Override
    public ResponseResult load(Short loadtype, ArticleHomeDto dto) {
        //1.校验参数
        //类型参数检验
        if(!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_MORE)&&!loadtype.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){
            loadtype = ArticleConstants.LOADTYPE_LOAD_MORE;
        }
        //文章频道校验
        if(StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstants.DEFAULT_TAG);
        }
        //时间校验
        if(dto.getMaxBehotTime() == null) dto.setMaxBehotTime(new Date());
        if(dto.getMinBehotTime() == null) dto.setMinBehotTime(new Date());
        //2.查询数据
        List<ArticleDto> articles = articleMapper.loadArticleList(dto, loadtype);
        //3.结果封装
        ResponseResult responseResult = ResponseResult.okResult(articles);
        return responseResult;
    }

    @Override
    public ResponseResult<RecommendVO> recommendList(RecommendDto dto) {
        List<RecommendVO> list = articleMapper.recommendList(dto);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult publish(AnswerDto dto) {
        //文章内容审核
        Map map = null;
        try {
            map = greenTextScan.greeTextScan(dto.getContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (map.get("labels") == null) {
            System.out.println("》》》》》审核通过》》》》》》");
        }else {
            return ResponseResult.errorResult(500,"文章内容包含违规信息");
        }
        //自管理的敏感词过滤
        boolean isSensitive = handleSensitiveScan(dto.getContent());
        if(isSensitive) {
            return ResponseResult.errorResult(500,"文章内容包含违规信息");
        }

        Article article = new Article();
        article.setAuthorId(dto.getAuthorId());
        article.setAuthorName(dto.getAuthorName());
        article.setImages(dto.getImages());
        article.setQuestionId(dto.getQuestionId());
        article.setPublishTime(LocalDateTime.now());
        articleMapper.insert(article);

        ArticleContent articleContent = new ArticleContent();
        articleContent.setContent(dto.getContent());
        articleContent.setArticleId(article.getId());
        articleContentMapper.insert(articleContent);
        return ResponseResult.okResult(null);
    }

    @Override
    public ResponseResult<RecommendVO> interest(Integer id) {
        List<UserVO> userVOList = userClient.followList(id).getData();
        // 使用流操作将UserVO列表转换为FollowVO列表
        List<FollowVO> followVOList = userVOList.stream()
                .map(userVO -> {
                    FollowVO followVO = new FollowVO();
                    followVO.setUser(userVO);
                    return followVO;
                })
                .collect(Collectors.toList());

        // 查询每个user回答过的问题
        for (FollowVO followVO : followVOList) {
            List<RecommendVO> questions = articleMapper.interestedList(followVO.getUser().getId());
            followVO.setQuestions(questions);
        }

        return ResponseResult.okResult(followVOList);
    }

    @Autowired
    private SensitiveMapper sensitiveMapper;

    /**
     * 自管理的敏感词审核
     * @param content
     * @return
     */
    private boolean handleSensitiveScan(String content) {

        boolean flag = false;

        //获取所有的敏感词
//        List<Sensitive> sensitives = sensitiveMapper.selectList(Wrappers.<Sensitive>lambdaQuery().select(Sensitive::getSensitives));
        // 查询敏感数据并存储在List中
        List<Sensitive> sensitives = sensitiveMapper.selectSensitives();//sensitiveMapper.selectList(Wrappers.<Sensitive>lambdaQuery().select(Sensitive::getSensitives));
        List<String> sensitiveList = sensitives.stream().map(Sensitive::getSensitives).collect(Collectors.toList());

        //初始化敏感词库
        SensitiveWordUtil.initMap(sensitiveList);

        //查看文章中是否包含敏感词
        Map<String, Integer> map = SensitiveWordUtil.matchWords(content);
        if(map.size() >0){
//            updateWmNews(news,(short) 2,"当前文章中存在违规内容"+map);
            flag = true;
        }

        return flag;
    }

    @Autowired
    private CacheService cacheService;

    @Override
    public ResponseResult loadArticleBehavior(ArticleInfoDto dto) {

        //0.检查参数
        if (dto == null || dto.getArticleId() == null || dto.getAuthorId() == null) {
            return ResponseResult.errorResult(HttpCodeEnum.PARAM_INVALID);
        }

        //{ "isfollow": true, "islike": true,"isunlike": false,"iscollection": true }
        boolean isfollow = false, islike = false, isunlike = false, iscollection = false;

        User user = ThreadLocalUtil.getUser();
        if(user != null){
            //喜欢行为
            String likeBehaviorJson = (String) cacheService.hGet(BehaviorConstants.LIKE_BEHAVIOR + dto.getArticleId().toString(), user.getId().toString());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(likeBehaviorJson)){
                islike = true;
            }
            //不喜欢的行为
            String unLikeBehaviorJson = (String) cacheService.hGet(BehaviorConstants.UN_LIKE_BEHAVIOR + dto.getArticleId().toString(), user.getId().toString());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(unLikeBehaviorJson)){
                isunlike = true;
            }
            //是否收藏
            String collctionJson = (String) cacheService.hGet(BehaviorConstants.COLLECTION_BEHAVIOR+user.getId(),dto.getArticleId().toString());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(collctionJson)){
                iscollection = true;
            }

//            //是否关注
//            Double score = cacheService.zScore(BehaviorConstants.APUSER_FOLLOW_RELATION + user.getId(), dto.getAuthorId().toString());
//            System.out.println(score);
//            if(score != null){
//                isfollow = true;
//            }

        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("isfollow", isfollow);
        resultMap.put("islike", islike);
        resultMap.put("isunlike", isunlike);
        resultMap.put("iscollection", iscollection);

        return ResponseResult.okResult(resultMap);
    }

    /**
     * 更新文章的分值  同时更新缓存中的热点文章数据
     * @param mess
     */
    @Override
    public void updateScore(ArticleVisitStreamMess mess) {
        //1.更新文章的阅读、点赞、收藏、评论的数量
        Article article = updateArticle(mess);
        //2.计算文章的分值
        Integer score = computeScore(article);
        score = score * 3;

        //3.替换当前文章对应频道的热点数据
        replaceDataToRedis(article, score, ArticleConstants.HOT_ARTICLE_FIRST_PAGE + article.getChannelId());

        //4.替换推荐对应的热点数据
        replaceDataToRedis(article, score, ArticleConstants.HOT_ARTICLE_FIRST_PAGE + ArticleConstants.DEFAULT_TAG);

    }

    @Override
    public ResponseResult load2(ArticleHomeDto dto, Short type, boolean firstPage) {
        String jsonStr = cacheService.get(ArticleConstants.HOT_ARTICLE_FIRST_PAGE + 6);
        if(org.apache.commons.lang3.StringUtils.isNotBlank(jsonStr)){
            List<HotArticleVo> hotArticleVoList = JSON.parseArray(jsonStr, HotArticleVo.class);
            ResponseResult responseResult = ResponseResult.okResult(hotArticleVoList);
            return responseResult;
        }
        return load(type,dto);
    }

    /**
     * 替换数据并且存入到redis
     * @param apArticle
     * @param score
     * @param s
     */
    private void replaceDataToRedis(Article apArticle, Integer score, String s){
        String articleListStr = cacheService.get(s);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(articleListStr)) {
            List<HotArticleVo> hotArticleVoList = JSON.parseArray(articleListStr, HotArticleVo.class);

            boolean flag = true;

            //如果缓存中存在该文章，只更新分值
            for (HotArticleVo hotArticleVo : hotArticleVoList) {
                if (hotArticleVo.getId().equals(apArticle.getId())) {
                    hotArticleVo.setScore(score);
                    flag = false;
                    break;
                }
            }

            //如果缓存中不存在，查询缓存中分值最小的一条数据，进行分值的比较，如果当前文章的分值大于缓存中的数据，就替换
            if (flag) {
                if (hotArticleVoList.size() >= 30) {
                    hotArticleVoList = hotArticleVoList.stream().sorted(Comparator.comparing(HotArticleVo::getScore).reversed()).collect(Collectors.toList());
                    HotArticleVo lastHot = hotArticleVoList.get(hotArticleVoList.size() - 1);
                    if (lastHot.getScore() < score) {
                        hotArticleVoList.remove(lastHot);
                        HotArticleVo hot = new HotArticleVo();
                        BeanUtils.copyProperties(apArticle, hot);
                        hot.setScore(score);
                        hotArticleVoList.add(hot);
                    }


                } else {
                    HotArticleVo hot = new HotArticleVo();
                    BeanUtils.copyProperties(apArticle, hot);
                    hot.setScore(score);
                    hotArticleVoList.add(hot);
                }
            }
            //缓存到redis
            hotArticleVoList = hotArticleVoList.stream().sorted(Comparator.comparing(HotArticleVo::getScore).reversed()).collect(Collectors.toList());
            cacheService.set(s, JSON.toJSONString(hotArticleVoList));

        }
    }

    /**
     * 计算文章的具体分值
     * @param article
     * @return
     */
    private Integer computeScore(Article article) {
        Integer score = 0;
        if(article.getLikes() != null){
            score += article.getLikes() * ArticleConstants.HOT_ARTICLE_LIKE_WEIGHT;
        }
        if(article.getViews() != null){
            score += article.getViews();
        }
        if(article.getComment() != null){
            score += article.getComment() * ArticleConstants.HOT_ARTICLE_COMMENT_WEIGHT;
        }
        if(article.getCollection() != null){
            score += article.getCollection() * ArticleConstants.HOT_ARTICLE_COLLECTION_WEIGHT;
        }

        return score;
    }

    /**
     * 更新文章行为数量
     * @param mess
     */
    private Article updateArticle(ArticleVisitStreamMess mess) {
        Article apArticle = getById(mess.getArticleId());
        apArticle.setCollection(apArticle.getCollection()==null?0:apArticle.getCollection()+mess.getCollect());
        apArticle.setComment(apArticle.getComment()==null?0:apArticle.getComment()+mess.getComment());
        apArticle.setLikes(apArticle.getLikes()==null?0:apArticle.getLikes()+mess.getLike());
        apArticle.setViews(apArticle.getViews()==null?0:apArticle.getViews()+mess.getView());
        updateById(apArticle);
        return apArticle;
    }




}
