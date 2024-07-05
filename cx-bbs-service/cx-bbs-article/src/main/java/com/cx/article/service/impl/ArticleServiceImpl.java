package com.cx.article.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleContentMapper;
import com.cx.article.mapper.ArticleMapper;
import com.cx.article.mapper.QuestionMapper;
import com.cx.article.mapper.SensitiveMapper;
import com.cx.article.service.ArticleService;
import com.cx.common.aliyun.GreenTextScan;
import com.cx.common.constants.ArticleConstants;
import com.cx.feign.client.UserClient;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.ArticleDto;
import com.cx.model.article.dtos.RecommendDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.pojos.ArticleContent;
import com.cx.model.article.pojos.Question;
import com.cx.model.article.pojos.Sensitive;
import com.cx.model.article.vo.ArticleVO;
import com.cx.model.article.vo.FollowVO;
import com.cx.model.article.vo.RecommendVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.user.UserFollow;
import com.cx.model.user.vo.UserVO;
import com.cx.utils.common.ConvertUtil;
import com.cx.utils.common.SensitiveWordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

}
