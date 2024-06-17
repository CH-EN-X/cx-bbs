package com.cx.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.article.dtos.ArticleDto;
import com.cx.model.article.pojos.Article;
import com.cx.model.article.dtos.ArticleHomeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    public List<ArticleDto> loadArticleList(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);



//        public List<Map<String,Object>> loadArticleList(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);


}