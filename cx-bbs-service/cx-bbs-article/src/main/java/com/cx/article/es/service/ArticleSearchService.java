package com.cx.article.es.service;

import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.search.dtos.UserSearchDto;

import java.io.IOException;

public interface ArticleSearchService {

    /**
     ES文章分页搜索
     @return
     */
    ResponseResult search(UserSearchDto userSearchDto) throws IOException;
}