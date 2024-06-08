package com.cx.model.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@ApiModel(value = "User对象", description = "用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("密码、通信等加密盐")
    private String salt;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("密码,md5加密")
    private String password;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("头像")
    private String image;

    @ApiModelProperty("0 男	            1 女	            2 未知")
    private Byte sex;

    @ApiModelProperty("0 未	            1 是")
    private Byte isCertification;

    @ApiModelProperty("是否身份认证")
    private Byte isIdentityAuthentication;

    @ApiModelProperty("0正常	            1锁定")
    private Byte status;

    @ApiModelProperty("0 普通用户	            1 自媒体人	            2 大V")
    private Byte flag;

    @ApiModelProperty("注册时间")
    private LocalDateTime createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(Byte isCertification) {
        this.isCertification = isCertification;
    }

    public Byte getIsIdentityAuthentication() {
        return isIdentityAuthentication;
    }

    public void setIsIdentityAuthentication(Byte isIdentityAuthentication) {
        this.isIdentityAuthentication = isIdentityAuthentication;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "User{" +
            "id = " + id +
            ", salt = " + salt +
            ", name = " + name +
            ", password = " + password +
            ", phone = " + phone +
            ", image = " + image +
            ", sex = " + sex +
            ", isCertification = " + isCertification +
            ", isIdentityAuthentication = " + isIdentityAuthentication +
            ", status = " + status +
            ", flag = " + flag +
            ", createdTime = " + createdTime +
        "}";
    }
}
