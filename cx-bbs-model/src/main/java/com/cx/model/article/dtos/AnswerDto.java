package com.cx.model.article.dtos;

import com.cx.model.article.pojos.Question;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    Integer authorId;
    String authorName;
    //头像
    String images;
    //绑定问题id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long questionId;

    //内容
    String content;
}
