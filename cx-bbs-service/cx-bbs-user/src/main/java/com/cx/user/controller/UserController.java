package com.cx.user.controller;

import com.cx.model.user.User;
import com.cx.model.user.dtos.LoginDto;
import com.cx.user.service.IUserService;
import com.cx.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.security.PublicKey;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Controller
@RequestMapping("/api/login")
@Api(value = "用户登录",tags = "用户登录")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login_auth")
    @ApiOperation("")
    public ResponseResult<User> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

}
