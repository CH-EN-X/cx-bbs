package com.cx.model.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 提问表，发布的提问
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@ApiModel(value = "Questions对象", description = "提问表，发布的提问")
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("提问的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("回答的文章id")
    private Long articleId;

    @ApiModelProperty("提问内容")
    private String content;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("文章作者的ID")
    private Integer authorId;

    @ApiModelProperty("点赞数量")
    private String likes;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Questions{" +
            "id = " + id +
            ", articleId = " + articleId +
            ", content = " + content +
            ", title = " + title +
            ", authorId = " + authorId +
            ", likes = " + likes +
        "}";
    }
}
