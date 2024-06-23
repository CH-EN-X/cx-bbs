package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleContentMapper;
import com.cx.article.service.ArticleContentService;
import com.cx.model.article.pojos.ArticleContent;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 已发布文章内容表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements ArticleContentService {

}
