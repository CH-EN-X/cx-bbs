package com.cx.behavior.service.impl;


import com.alibaba.fastjson.JSON;
import com.cx.common.redis.CacheService;
import com.cx.model.behavior.dtos.UnLikesBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.user.User;
import com.cx.utils.thread.ThreadLocalUtil;
import com.cx.behavior.service.ApUnlikesBehaviorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * APP不喜欢行为表 服务实现类
 * </p>
 *
 * @author itheima
 */
@Slf4j
@Service
public class ApUnlikesBehaviorServiceImpl implements ApUnlikesBehaviorService {

    @Resource
    private CacheService cacheService;

    @Override
    public ResponseResult unLike(UnLikesBehaviorDto dto) {

        if(dto.getArticleId() == null){
            return ResponseResult.errorResult(HttpCodeEnum.PARAM_INVALID);
        }

        User user = ThreadLocalUtil.getUser();
        if(user == null){
            return ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
        }

        if(dto.getType()==0){
            log.info("保存当前key:{} ,{}, {}", dto.getArticleId(), user.getId(), dto);
            cacheService.hPut("UNLIKE-BEHAVIOR-"+dto.getArticleId().toString(),user.getId().toString(), JSON.toJSONString(dto));
        }else {
            log.info("删除当前key:{} ,{}, {}", dto.getArticleId(), user.getId(), dto);
            cacheService.hDelete("UNLIKE-BEHAVIOR-"+dto.getArticleId().toString(),user.getId().toString());
        }

        return ResponseResult.okResult(HttpCodeEnum.SUCCESS);
    }
}