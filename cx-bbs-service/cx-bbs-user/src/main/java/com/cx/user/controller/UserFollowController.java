package com.cx.user.controller;

import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.dtos.FollowDto;
import com.cx.user.service.IUserFollowService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/follow")
@CrossOrigin
public class UserFollowController {

    @Resource
    private IUserFollowService userFollowService;

    @RequestMapping("/toFollow")
    public ResponseResult follow(@RequestBody FollowDto dto){
       return userFollowService.follow(dto);
    }

    @RequestMapping("/unFollow")
    public ResponseResult unFollow(@RequestBody FollowDto dto){
        return userFollowService.unFollow(dto);
    }
}
