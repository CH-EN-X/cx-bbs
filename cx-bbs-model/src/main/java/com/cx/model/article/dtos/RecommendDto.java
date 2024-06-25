package com.cx.model.article.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendDto {
//    // 分页size
//    Integer size;
    // 页page
    Integer page;//下拉框到底时再次请求，拼接在后面
    // 类型type
    //Integer type;

}
