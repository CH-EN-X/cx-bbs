package com.cx.article.controller;

import com.cx.article.service.CommentService;
import com.cx.model.article.dtos.CommentDto;
import com.cx.model.article.pojos.Comment;
import com.cx.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/load")
    public ResponseResult commentList(@RequestBody CommentDto dto){
        return commentService.commentList(dto);
    }

    @RequestMapping("sendComment")
    public ResponseResult sendComment(@RequestBody Comment comment){
        return commentService.sendComment(comment);
    }

}
