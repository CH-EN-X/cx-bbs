package com.cx.user.controller;

import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import com.cx.model.user.dtos.FollowDto;
import com.cx.model.user.vo.UserVO;
import com.cx.user.service.IUserFollowService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/ifFollow")
    public ResponseResult ifFollow(@RequestBody FollowDto dto){
        return userFollowService.ifFollow(dto);
    }

    @RequestMapping("/followList/{id}")
    public ResponseResult<List<UserVO>> followList(@PathVariable("id") Integer id){
        return userFollowService.followList(id);
    }
}
