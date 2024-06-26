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
 * 
 * </p>
 *
 * @author cx
 * @since 2024-06-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("0问题的  1回答的")
    private Byte type;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishedTime;

    @ApiModelProperty("发布评论的人id")
    private Integer userId;


}
