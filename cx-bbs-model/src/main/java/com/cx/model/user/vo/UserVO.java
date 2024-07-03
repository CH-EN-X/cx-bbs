package com.cx.model.user.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    //id
    private Integer id;
    //用户名
    private String phone;
    //昵称
    private String name;
    //头像
    private String image;
    //性别（0 男  1 女  2 未知）
    private Byte sex;
    //个性标签
}
