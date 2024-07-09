package com.cx.behavior.controller.v1;

import com.cx.behavior.service.ApReadBehaviorService;
import com.cx.model.behavior.dtos.ReadBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/read_behavior")
public class ApReadBehaviorController {

    @Autowired
    private ApReadBehaviorService apReadBehaviorService;

    @PostMapping
    public ResponseResult readBehavior(@RequestBody ReadBehaviorDto dto){
        return apReadBehaviorService.readBehavior(dto);
    }
}
