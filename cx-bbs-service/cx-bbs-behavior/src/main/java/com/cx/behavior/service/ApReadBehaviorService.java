package com.cx.behavior.service;


import com.cx.model.behavior.dtos.ReadBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;

public interface ApReadBehaviorService {

    /**
     * 保存阅读行为
     * @param dto
     * @return
     */
    public ResponseResult readBehavior(ReadBehaviorDto dto);
}
