package com.cx.common.exception;

import com.cx.model.common.enums.HttpCodeEnum;

public class CustomException extends RuntimeException {

    private HttpCodeEnum appHttpCodeEnum;

    public CustomException(HttpCodeEnum appHttpCodeEnum){
        this.appHttpCodeEnum = appHttpCodeEnum;
    }

    public HttpCodeEnum getHttpCodeEnum() {
        return appHttpCodeEnum;
    }
}
