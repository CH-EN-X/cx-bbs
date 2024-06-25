package com.cx.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 已发布文章内容表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article_content")
@ApiModel(value = "ArticleContent对象", description = "已发布文章内容表")
public class ArticleContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("文章内容")
    private String content;


}
