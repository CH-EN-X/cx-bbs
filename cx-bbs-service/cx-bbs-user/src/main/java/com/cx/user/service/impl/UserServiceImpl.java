package com.cx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.User;
import com.cx.model.user.dtos.LoginDto;
import com.cx.user.mapper.UserMapper;
import com.cx.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public ResponseResult<User> login(LoginDto loginDto) {
        return null;
    }
}
