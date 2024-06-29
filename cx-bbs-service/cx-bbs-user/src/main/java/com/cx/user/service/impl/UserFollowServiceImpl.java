package com.cx.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.User;
import com.cx.model.user.UserFollow;
import com.cx.model.user.dtos.FollowDto;
import com.cx.model.user.vo.UserVO;
import com.cx.user.mapper.UserFollowMapper;
import com.cx.user.mapper.UserMapper;
import com.cx.user.service.IUserFollowService;
import com.cx.utils.common.ConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseResult follow(FollowDto dto) {
        //判断是否已关注
        LambdaQueryWrapper<UserFollow> queryWrapper = Wrappers.<UserFollow>lambdaQuery()
                .eq(UserFollow::getUserId, dto.getUserId())
                .eq(UserFollow::getFollowId, dto.getFollowId());
        List<UserFollow> userFollowList = userFollowMapper.selectList(queryWrapper);
        if (userFollowList.size() > 0) {
            return ResponseResult.errorResult(501,"您已经关注过他了");
        }

        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(dto.getUserId());
        userFollow.setFollowId(dto.getFollowId());
//        userFollow.setCreatedTime();
        userFollowMapper.insert(userFollow);
        return ResponseResult.okResult(200,"关注成功");
    }

    @Override
    public ResponseResult unFollow(FollowDto dto) {
        LambdaQueryWrapper<UserFollow> queryWrapper = Wrappers.<UserFollow>lambdaQuery()
                .eq(UserFollow::getUserId, dto.getUserId())
                .eq(UserFollow::getFollowId, dto.getFollowId());
        UserFollow userFollow = userFollowMapper.selectOne(queryWrapper);
        //是否已关注
        if (userFollow != null){
            userFollowMapper.delete(queryWrapper);
            return ResponseResult.okResult(200,"取消成功");
        }
        return ResponseResult.okResult(200,"你还没有关注");
    }

    @Override
    public ResponseResult ifFollow(FollowDto dto) {
        //判断是否已关注
        LambdaQueryWrapper<UserFollow> queryWrapper = Wrappers.<UserFollow>lambdaQuery()
                .eq(UserFollow::getUserId, dto.getUserId())
                .eq(UserFollow::getFollowId, dto.getFollowId());
        List<UserFollow> userFollowList = userFollowMapper.selectList(queryWrapper);
        if (userFollowList.size() > 0) {
            return ResponseResult.errorResult(200,"您已经关注过他了");
        }
        return ResponseResult.okResult(501,"未关注");
    }

    @Override
    public ResponseResult<List<UserVO>> followList(Integer id) {
        LambdaQueryWrapper<UserFollow> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserFollow::getUserId, id);

        List<UserFollow> userFollowList = userFollowMapper.selectList(wrapper);

        List<Integer> followIds = userFollowList.stream()
                .map(UserFollow::getFollowId)
                .collect(Collectors.toList());

        LambdaQueryWrapper<User> userWrapper = Wrappers.lambdaQuery();
        userWrapper.in(User::getId, followIds);

        List<UserVO> userVOS = ConvertUtil.entityToVoList(userMapper.selectList(userWrapper), UserVO.class);

        return ResponseResult.okResult(userVOS);
    }


}
