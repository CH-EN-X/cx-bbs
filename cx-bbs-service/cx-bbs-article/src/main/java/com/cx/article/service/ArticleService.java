package com.cx.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.article.ArticleInfoDto;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.RecommendDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.article.vo.RecommendVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.mess.ArticleVisitStreamMess;

public interface ArticleService extends IService<Article> {

    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载关注  2为加载最新
     * @param dto
     * @return
     */
    ResponseResult load(Short loadtype, ArticleHomeDto dto);

    ResponseResult<RecommendVO> recommendList(RecommendDto dto);

    ResponseResult publish(AnswerDto dto);

    ResponseResult<RecommendVO> interest(Integer id);

    ResponseResult loadArticleBehavior(ArticleInfoDto dto);

    void updateScore(ArticleVisitStreamMess mess);

    ResponseResult load2(ArticleHomeDto dto, Short type, boolean b);


//    ResponseResult loadContent(Integer id);

}
