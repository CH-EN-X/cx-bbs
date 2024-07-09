package com.cx.behavior.controller.v1;


import com.cx.model.behavior.dtos.LikesBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.behavior.service.ApLikesBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/likes_behavior")
public class ApLikesBehaviorController {

    @Autowired
    private ApLikesBehaviorService apLikesBehaviorService;

    @PostMapping
    public ResponseResult like(@RequestBody LikesBehaviorDto dto){
        return apLikesBehaviorService.like(dto);
    }
}
