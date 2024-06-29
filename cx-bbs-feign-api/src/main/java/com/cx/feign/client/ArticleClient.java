package com.cx.feign.client;

import com.cx.model.common.dtos.ResponseResult;
import com.cx.model.user.UserFollow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cx-bbs-article")
public interface ArticleClient {

}
