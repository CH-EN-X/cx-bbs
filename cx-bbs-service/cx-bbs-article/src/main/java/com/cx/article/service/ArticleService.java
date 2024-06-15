package com.cx.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import com.cx.model.common.dtos.ResponseResult;

public interface ArticleService  extends IService<Article> {

    /**
     * 根据参数加载文章列表
     * @param loadtype 1为加载关注  2为加载最新
     * @param dto
     * @return
     */
    ResponseResult load(Short loadtype, ArticleHomeDto dto);

}
