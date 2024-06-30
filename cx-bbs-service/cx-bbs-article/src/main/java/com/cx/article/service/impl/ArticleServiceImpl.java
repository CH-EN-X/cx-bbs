package com.cx.article.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleContentMapper;
import com.cx.article.mapper.ArticleMapper;
import com.cx.article.mapper.QuestionMapper;
import com.cx.article.service.ArticleService;
import com.cx.common.constants.ArticleConstants;
import com.cx.feign.client.UserClient;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.ArticleDto;
import com.cx.model.article.dtos.RecommendDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.pojos.ArticleContent;
import com.cx.model.article.pojos.Question;
import com.cx.model.article.vo.ArticleVO;
import com.cx.model.article.vo.FollowVO;
import com.cx.model.article.vo.RecommendVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import com.cx.model.user.vo.UserVO;
import com.cx.utils.common.ConvertUtil;
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


}
