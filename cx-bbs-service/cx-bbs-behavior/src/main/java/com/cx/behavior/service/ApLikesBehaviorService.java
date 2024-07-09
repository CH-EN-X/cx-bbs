package com.cx.behavior.service;


import com.cx.model.behavior.dtos.LikesBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;

public interface ApLikesBehaviorService {

    /**
     * 存储喜欢数据
     * @param dto
     * @return
     */
    public ResponseResult like(LikesBehaviorDto dto);
}
