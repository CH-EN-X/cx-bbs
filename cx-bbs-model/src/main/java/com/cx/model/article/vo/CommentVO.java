package com.cx.model.article.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cx.model.user.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
    //评论id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

//    //0问题的评论  1回答的评论
//    private Byte type;

//    //对应的问题/回答的ID
//    private Long articleId;

    //评论内容
    private String content;

    //发布时间
    private LocalDateTime publishedTime;

    //发布评论的人
    private UserVO user;
}
