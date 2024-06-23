package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.ArticleConfigMapper;
import com.cx.article.service.ArticleConfigService;
import com.cx.model.article.pojos.ArticleConfig;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 已发布文章配置表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class ArticleConfigServiceImpl extends ServiceImpl<ArticleConfigMapper, ArticleConfig> implements ArticleConfigService {

}
