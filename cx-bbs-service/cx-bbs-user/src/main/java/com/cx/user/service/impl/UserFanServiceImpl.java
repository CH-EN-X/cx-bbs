package com.cx.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.model.user.UserFan;
import com.cx.user.mapper.UserFanMapper;
import com.cx.user.service.IUserFanService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户粉丝信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class UserFanServiceImpl extends ServiceImpl<UserFanMapper, UserFan> implements IUserFanService {

}
