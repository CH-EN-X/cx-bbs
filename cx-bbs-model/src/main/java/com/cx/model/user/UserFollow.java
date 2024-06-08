package com.cx.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户关注信息表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@TableName("user_follow")
@ApiModel(value = "UserFollow对象", description = "用户关注信息表")
public class UserFollow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("关注作者ID")
    private Integer followId;

    @ApiModelProperty("粉丝昵称")
    private String followName;

    @ApiModelProperty("关注度	            0 偶尔感兴趣	            1 一般	            2 经常	            3 高度")
    private Byte level;

    @ApiModelProperty("是否动态通知")
    private Byte isNotice;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Byte isNotice) {
        this.isNotice = isNotice;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "UserFollow{" +
            "id = " + id +
            ", userId = " + userId +
            ", followId = " + followId +
            ", followName = " + followName +
            ", level = " + level +
            ", isNotice = " + isNotice +
            ", createdTime = " + createdTime +
        "}";
    }
}
