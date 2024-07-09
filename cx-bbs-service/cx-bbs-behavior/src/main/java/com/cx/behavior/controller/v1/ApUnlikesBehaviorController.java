package com.cx.behavior.controller.v1;

import com.cx.model.behavior.dtos.UnLikesBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.behavior.service.ApUnlikesBehaviorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/un_likes_behavior")
public class ApUnlikesBehaviorController {

    @Autowired
    private ApUnlikesBehaviorService apUnlikesBehaviorService;

    @PostMapping
    public ResponseResult unLike(@RequestBody UnLikesBehaviorDto dto){
        return apUnlikesBehaviorService.unLike(dto);
    }
}