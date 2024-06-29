package com.cx.feign.client;

import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import com.cx.model.user.vo.UserVO;
import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "cx-bbs-user") // 指定要调用的服务名
public interface UserClient {
    @GetMapping("/api/user/{id}") // 远程调用的接口地址
    ResponseResult<UserVO> getUser(@PathVariable("id") Integer id); // 定义对应的方法，用于远程调用获取用户信息

    @RequestMapping("/api/follow/followList/{id}")
    ResponseResult<List<UserVO>> followList(@PathVariable("id") Integer id);
}
