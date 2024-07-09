package com.cx.behavior.service.impl;


import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cx.behavior.service.ApReadBehaviorService;
import com.cx.common.constants.HotArticleConstants;
import com.cx.common.redis.CacheService;
import com.cx.model.behavior.dtos.ReadBehaviorDto;
import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.common.enums.HttpCodeEnum;
import com.cx.model.mess.UpdateArticleMess;
import com.cx.model.user.User;
import com.cx.utils.thread.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
@Slf4j
public class ApReadBehaviorServiceImpl implements ApReadBehaviorService {

    @Resource
    private CacheService cacheService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public ResponseResult readBehavior(ReadBehaviorDto dto) {
        //1.检查参数
        if(dto == null || dto.getArticleId() == null){
            return ResponseResult.errorResult(HttpCodeEnum.PARAM_INVALID);
        }

        //2.是否登录
        User user = ThreadLocalUtil.getUser();
        if(user == null){
            return ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
        }
        //更新阅读次数
        String readBehaviorJson = (String) cacheService.hGet(dto.getArticleId().toString(), user.getId().toString());
        if(StringUtils.isNotBlank(readBehaviorJson)){
            ReadBehaviorDto readBehaviorDto = JSON.parseObject(readBehaviorJson, ReadBehaviorDto.class);
            dto.setCount((short)(readBehaviorDto.getCount()+dto.getCount()));
        }
        // 保存当前key
        log.info("保存当前key:{} {} {}", dto.getArticleId(), user.getId(), dto);
        cacheService.hPut("READ-BEHAVIOR-" + dto.getArticleId().toString(), user.getId().toString(), JSON.toJSONString(dto));

        //发送消息，数据聚合
        UpdateArticleMess mess = new UpdateArticleMess();
        mess.setArticleId(dto.getArticleId());
        mess.setType(UpdateArticleMess.UpdateArticleType.VIEWS);
        mess.setAdd(1);
        kafkaTemplate.send(HotArticleConstants.HOT_ARTICLE_SCORE_TOPIC, JSON.toJSONString(mess));

        return ResponseResult.okResult(HttpCodeEnum.SUCCESS);

    }
}
