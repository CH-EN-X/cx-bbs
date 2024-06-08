package com.cx.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.User;
import com.cx.model.user.dtos.LoginDto;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
public interface IUserService extends IService<User> {

    ResponseResult<User> login(LoginDto loginDto);
}
