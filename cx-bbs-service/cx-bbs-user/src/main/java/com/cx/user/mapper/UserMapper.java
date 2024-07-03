package com.cx.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.model.user.User;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
public interface UserMapper extends BaseMapper<User> {

    void updateInfo(User user);
}
