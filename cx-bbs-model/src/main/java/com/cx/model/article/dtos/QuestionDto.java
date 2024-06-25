package com.cx.model.article.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    //标题
    private String title;

    //描述
    private String content;

    //文章作者的ID
    private Integer authorId;


}
