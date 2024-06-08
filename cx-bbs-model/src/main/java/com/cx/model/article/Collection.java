package com.cx.model.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 收藏信息表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@ApiModel(value = "Collection对象", description = "收藏信息表")
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("实体ID")
    private Integer entryId;

    @ApiModelProperty("文章ID")
    private Long articleId;

    @ApiModelProperty("点赞内容类型	            0文章	            1动态")
    private Byte type;

    @ApiModelProperty("创建时间")
    private LocalDateTime collectionTime;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public LocalDateTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalDateTime collectionTime) {
        this.collectionTime = collectionTime;
    }

    public LocalDateTime getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(LocalDateTime publishedTime) {
        this.publishedTime = publishedTime;
    }

    @Override
    public String toString() {
        return "Collection{" +
            "id = " + id +
            ", entryId = " + entryId +
            ", articleId = " + articleId +
            ", type = " + type +
            ", collectionTime = " + collectionTime +
            ", publishedTime = " + publishedTime +
        "}";
    }
}
