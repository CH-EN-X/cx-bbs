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
 * 实名认证信息表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@TableName("user_realname")
@ApiModel(value = "UserRealname对象", description = "实名认证信息表")
public class UserRealname implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("账号ID")
    private Integer userId;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("资源名称")
    private String idno;

    @ApiModelProperty("正面照片")
    private String fontImage;

    @ApiModelProperty("背面照片")
    private String backImage;

    @ApiModelProperty("手持照片")
    private String holdImage;

    @ApiModelProperty("活体照片")
    private String liveImage;

    @ApiModelProperty("状态	            0 创建中	            1 待审核	            2 审核失败	            9 审核通过")
    private Byte status;

    @ApiModelProperty("拒绝原因")
    private String reason;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("提交时间")
    private LocalDateTime submitedTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getFontImage() {
        return fontImage;
    }

    public void setFontImage(String fontImage) {
        this.fontImage = fontImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getHoldImage() {
        return holdImage;
    }

    public void setHoldImage(String holdImage) {
        this.holdImage = holdImage;
    }

    public String getLiveImage() {
        return liveImage;
    }

    public void setLiveImage(String liveImage) {
        this.liveImage = liveImage;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getSubmitedTime() {
        return submitedTime;
    }

    public void setSubmitedTime(LocalDateTime submitedTime) {
        this.submitedTime = submitedTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "UserRealname{" +
            "id = " + id +
            ", userId = " + userId +
            ", name = " + name +
            ", idno = " + idno +
            ", fontImage = " + fontImage +
            ", backImage = " + backImage +
            ", holdImage = " + holdImage +
            ", liveImage = " + liveImage +
            ", status = " + status +
            ", reason = " + reason +
            ", createdTime = " + createdTime +
            ", submitedTime = " + submitedTime +
            ", updatedTime = " + updatedTime +
        "}";
    }
}
