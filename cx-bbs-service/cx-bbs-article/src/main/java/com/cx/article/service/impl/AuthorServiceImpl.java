package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.AuthorMapper;
import com.cx.article.service.AuthorService;
import com.cx.model.article.pojos.Author;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章作者信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
