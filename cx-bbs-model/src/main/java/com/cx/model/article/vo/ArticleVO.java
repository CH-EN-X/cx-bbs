package com.cx.model.article.vo;

import com.cx.model.article.pojos.Article;
import com.cx.model.article.pojos.ArticleContent;
import com.cx.model.article.pojos.Questions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    Questions questions;
    Article article;
    ArticleContent  content;
}
