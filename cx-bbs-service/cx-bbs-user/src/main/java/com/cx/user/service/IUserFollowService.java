package com.cx.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import com.cx.model.user.dtos.FollowDto;

/**
 * <p>
 * 用户关注信息表 服务类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
public interface IUserFollowService extends IService<UserFollow> {

    ResponseResult follow(FollowDto dto);

    ResponseResult unFollow(FollowDto dto);
}
