package com.cx.model.article.dtos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
//    private Article article;
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("文章作者的ID")
    private Integer authorId;

    @ApiModelProperty("作者昵称")
    private String authorName;

    @ApiModelProperty("文章所属频道ID")
    private Integer channelId;

    @ApiModelProperty("频道名称")
    private String channelName;

    @ApiModelProperty("文章布局	            0 无图文章	            1 单图文章	            2 多图文章")
    private Byte layout;

    @ApiModelProperty("文章标记	            0 普通文章	            1 热点文章	            2 置顶文章	            3 精品文章	            4 大V 文章")
    private Byte flag;

    @ApiModelProperty("文章图片	            多张逗号分隔")
    private String images;

    @ApiModelProperty("文章标签最多3个 逗号分隔")
    private String labels;

    @ApiModelProperty("点赞数量")
    private Integer likes;

    @ApiModelProperty("收藏数量")
    private Integer collection;

    @ApiModelProperty("评论数量")
    private Integer comment;

    @ApiModelProperty("阅读数量")
    private Integer views;

    @ApiModelProperty("省市")
    private Integer provinceId;

    @ApiModelProperty("市区")
    private Integer cityId;

    @ApiModelProperty("区县")
    private Integer countyId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("发布时间")
    private LocalDateTime publishTime;

    @ApiModelProperty("同步状态")
    private Byte syncStatus;

    @ApiModelProperty("来源")
    private Byte origin;

    private String staticUrl;
    //内容
    private String content;
    //问题id
    private String questionId;
}
