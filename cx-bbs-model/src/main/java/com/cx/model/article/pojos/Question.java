package com.cx.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 提问表，发布的提问
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Questions对象", description = "提问表，发布的提问")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("提问的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("提问内容")
    private String content;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("文章作者的ID")
    private Long authorId;

    @ApiModelProperty("点赞数量")
    private Integer likes;

    @ApiModelProperty("文章标签最多3个 逗号分隔")
    private String labels;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishTime;

}
