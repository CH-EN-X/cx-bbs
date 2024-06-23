package com.cx.article.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.CommentMapper;
import com.cx.article.service.CommentService;
import com.cx.model.article.pojos.Comment;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
