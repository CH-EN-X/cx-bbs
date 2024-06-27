package com.cx.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import com.cx.model.user.dtos.FollowDto;
import com.cx.user.mapper.UserFollowMapper;
import com.cx.user.service.IUserFollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户关注信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow> implements IUserFollowService {

    @Resource
    private UserFollowMapper userFollowMapper;

    @Override
    public ResponseResult follow(FollowDto dto) {
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(dto.getUserId());
        userFollow.setFollowId(dto.getFollowId());
//        userFollow.setCreatedTime();
        userFollowMapper.insert(userFollow);
        return ResponseResult.okResult(200,"关注成功");
    }
}
