package com.cx.article.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.article.mapper.CommentMapper;
import com.cx.article.service.CommentService;
import com.cx.feign.client.UserClient;
import com.cx.model.article.dtos.CommentDto;
import com.cx.model.article.pojos.Comment;
import com.cx.model.article.vo.CommentVO;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.user.vo.UserVO;
import com.cx.utils.common.ConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    CommentMapper commentMapper;

    @Resource
    UserClient userClient;

    @Override
    public ResponseResult commentList(CommentDto dto) {
        LambdaQueryWrapper<Comment> wrapper = Wrappers.<Comment>lambdaQuery()
                .eq(Comment::getArticleId, dto.getArticleId());

        List<Comment> comments = commentMapper.selectList(wrapper);

        List<CommentVO> commentVOList = ConvertUtil.entityToVoList(comments, CommentVO.class);
        for (CommentVO commentVO : commentVOList) {
            UserVO user = userClient.getUser(commentVO.getUserId()).getData();
            commentVO.setUser(user);

            //查询子评论
            List<CommentVO> commentChildren = ConvertUtil.entityToVoList(
                    commentMapper.selectList(
                            Wrappers.<Comment>lambdaQuery()
                                    .eq(Comment::getArticleId, commentVO.getId())
                    ),
                    CommentVO.class);
            for (CommentVO commentChild : commentChildren) {
                UserVO user2 = userClient.getUser(commentChild.getUserId()).getData();
                commentChild.setUser(user2);
            }
            commentVO.setComments(commentChildren);
        }
        return ResponseResult.okResult(commentVOList);
    }

    @Override
    public ResponseResult sendComment(Comment comment) {
        if (comment.getFlag() == 0){
            commentMapper.insert(comment);
        } else if (comment.getFlag() == 1) {
            commentMapper.insert(comment);
        }else {
            return ResponseResult.errorResult(HttpCodeEnum.SERVER_ERROR);
        }

        return null;
    }
}
