package com.cx.model.article.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    //0问题 1文章
    Byte type;
    //对象id（不改名字了）
    Long articleId;
    String content;
    Integer userId;
    //0评论 1回复
    Byte flag;
}
