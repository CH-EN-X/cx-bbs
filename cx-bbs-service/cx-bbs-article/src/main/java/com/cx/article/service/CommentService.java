package com.cx.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.article.dtos.CommentDto;
import com.cx.model.article.pojos.Comment;
import com.cx.model.common.dtos.ResponseResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cx
 * @since 2024-06-23
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(CommentDto dto);

    ResponseResult sendComment(Comment comment);
}
