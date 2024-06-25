package com.cx.model.article.vo;

import com.cx.model.article.pojos.Question;
import com.cx.model.user.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    //id
    @JsonFormat(shape = JsonFormat.Shape.STRING) //将 Long 类型转换成 String 类型
    private Long id;
    //作者id
    private Integer authorId;
    //作者
    private UserVO author;
    //内容
    private String content;
    //点赞数量
    private Integer likes;
    //收藏数量
    private Integer collection;
    //评论
    private List<CommentVO> comments;
//    //提问的id
//    private Long questionId;

}
