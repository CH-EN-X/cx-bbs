package com.cx.model.article.vo;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cx.model.article.pojos.Question;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    //提问内容
    private String content;

    //标题
    private String title;

    //文章作者的ID
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long authorId;

    //点赞数量(好问题)
    private Integer likes;

    //文章标签最多3个 逗号分隔
    private String labels;

    //发布时间
    private LocalDateTime publishTime;


}
