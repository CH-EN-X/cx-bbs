package com.cx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.article.pojos.ArticleContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleContentMapper extends BaseMapper<ArticleContent> {
}
