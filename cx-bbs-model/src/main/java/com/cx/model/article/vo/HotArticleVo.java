package com.cx.model.article.vo;

import com.cx.model.article.pojos.Article;
import lombok.Data;

@Data
public class HotArticleVo extends Article {
    /**
     * 文章分值
     */
    private Integer score;
}