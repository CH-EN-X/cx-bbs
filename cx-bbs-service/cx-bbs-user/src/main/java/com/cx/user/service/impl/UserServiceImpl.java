package com.cx.user.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.common.aliyun.util.AliyunSmsUtil;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.user.User;
import com.cx.model.user.dtos.LoginDto;
import com.cx.user.mapper.UserMapper;
import com.cx.user.service.IUserService;
import com.cx.utils.common.JwtUtil;
import com.cx.utils.common.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @Resource
    UserMapper userMapper;

    @Override
    public ResponseResult<User> login(LoginDto loginDto) {
        //1.正常登录（手机号+密码登录）
        if (!StringUtils.isBlank(loginDto.getPhone()) && !StringUtils.isBlank(loginDto.getPassword())){
            // 根据手机号查询用户信息
            // 使用条件构造器、lambda: 用loginDto.getPhone()去数据库查询，提取第一个结果
            User user =  getOne(Wrappers.<User>lambdaQuery().eq(User::getPhone,loginDto.getPhone()));
            if(user == null){
                return ResponseResult.errorResult(HttpCodeEnum.AP_USER_DATA_NOT_EXIST,"用户不存在");
            }

            // 比对密码 (MD5+盐值加密)
            String salt = user.getSalt();
            String pwd = loginDto.getPassword();
            pwd = DigestUtils.md5DigestAsHex( (pwd + salt).getBytes() );
            // 得到最后加密好的密码，然后进行比对
            if (!pwd.equals(user.getPassword())){
                return ResponseResult.errorResult(HttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            // 返回数据  jwt  user
            String token = JwtUtil.getToken(user.getId().longValue());
            Map<String, Object> map = new HashMap<>();
            map.put("token",token);
            user.setSalt("");
            user.setPassword("");
            map.put("user",user);
            return ResponseResult.okResult(map);

        } else {
        //2.游客登录 同样返回token  id = 0
            Map<String, Object> map = new HashMap<>();
            map.put("token", JwtUtil.getToken(0l));
            return ResponseResult.okResult(map);
        }

    }

    @Override
    public ResponseResult reg(LoginDto loginDto) {
        if (loginDto.getPhone() == null && loginDto.getPassword() == null) {
            return ResponseResult.errorResult(400,"用户名或密码");
        }
        if(userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getPhone, loginDto.getPhone())) != null){
            return ResponseResult.errorResult(400,"用户已存在");
        }
        //调用阿里云短信服务
        AliyunSmsUtil.setNewcode();
        String code = Integer.toString(AliyunSmsUtil.getNewcode());
        if (!code.equals(loginDto.getCode()) || loginDto.getCode() ==null || loginDto.getCode().equals("")){
            return ResponseResult.errorResult(2,"验证码错误");
        }
        //发短信
        try {
            SendSmsResponse response =AliyunSmsUtil.sendSms("13397356781",code);
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }

        User user = new User();
        String salt = "abc";
        user.setSalt(salt);
        user.setPhone(loginDto.getPhone());
        user.setPassword(MD5Utils.encode(loginDto.getPassword()+salt));
        user.setCreatedTime(LocalDateTime.now());
        userMapper.insert(user);
        return ResponseResult.okResult(200,"注册成功");
    }
}
