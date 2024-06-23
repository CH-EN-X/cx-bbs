package com.cx.model.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author cx
 * @since 2024-06-23
 */
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("0问题的  1回答的")
    private Byte type;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishedTime;

    @ApiModelProperty("发布评论的人id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(LocalDateTime publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id = " + id +
            ", type = " + type +
            ", articleId = " + articleId +
            ", content = " + content +
            ", publishedTime = " + publishedTime +
            ", userId = " + userId +
        "}";
    }
}
