package com.cx.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.model.user.UserRealname;
import com.cx.user.mapper.UserRealnameMapper;
import com.cx.user.service.IUserRealnameService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 实名认证信息表 服务实现类
 * </p>
 *
 * @author cx
 * @since 2024-06-08
 */
@Service
public class UserRealnameServiceImpl extends ServiceImpl<UserRealnameMapper, UserRealname> implements IUserRealnameService {

}
