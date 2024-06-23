package com.cx.model.article.vo;

import com.cx.model.article.pojos.Question;
import com.cx.model.user.vo.UserVO;
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
    private Long id;
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
