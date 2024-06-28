package com.cx.user.controller;

import com.cx.model.user.User;
import com.cx.model.user.dtos.LoginDto;
import com.cx.model.user.vo.UserVO;
import com.cx.user.service.IUserService;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.utils.common.ConvertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.PublicKey;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户登录",tags = "用户登录")
@CrossOrigin
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseResult<UserVO> getUser(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        //防止空指针
        if (user == null){
            return ResponseResult.okResult(null);
        }
        UserVO userVO = UserVO.builder()
                .id(user.getId())
                .image(user.getImage())
                .name(user.getName())
                .sex(user.getSex())
                .build();
        return ResponseResult.okResult(userVO);
    }

    @PostMapping("/reg")
    @ApiOperation("用户注册")
    public ResponseResult<User> reg(@RequestBody LoginDto loginDto){
        return userService.reg(loginDto);
    }

    @PostMapping("/login/login_auth")
    @ApiOperation("用户登录")
    public ResponseResult<User> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

}
