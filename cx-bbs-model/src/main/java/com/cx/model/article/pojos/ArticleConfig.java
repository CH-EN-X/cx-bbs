package com.cx.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 已发布文章配置表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@TableName("article_config")
@ApiModel(value = "ArticleConfig对象", description = "已发布文章配置表")
public class ArticleConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("是否可评论")
    private Byte isComment;

    @ApiModelProperty("是否转发")
    private Byte isForward;

    @ApiModelProperty("是否下架")
    private Byte isDown;

    @ApiModelProperty("是否已删除")
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Byte getIsComment() {
        return isComment;
    }

    public void setIsComment(Byte isComment) {
        this.isComment = isComment;
    }

    public Byte getIsForward() {
        return isForward;
    }

    public void setIsForward(Byte isForward) {
        this.isForward = isForward;
    }

    public Byte getIsDown() {
        return isDown;
    }

    public void setIsDown(Byte isDown) {
        this.isDown = isDown;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ArticleConfig{" +
            "id = " + id +
            ", articleId = " + articleId +
            ", isComment = " + isComment +
            ", isForward = " + isForward +
            ", isDown = " + isDown +
            ", isDelete = " + isDelete +
        "}";
    }
}
