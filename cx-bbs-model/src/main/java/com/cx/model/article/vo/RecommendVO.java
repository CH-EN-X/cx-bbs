package com.cx.model.article.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long questionId;

    String title;
    String articleId;
    Integer likes;
    String content;

}
