package com.zf.dubboserviceprovider.common;

import common.IErrorCode;

public enum ErrorCode implements IErrorCode {

    LOGIN_ERROR(40001,"没有该用户");


    private final int  code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
