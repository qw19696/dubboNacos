package com.zf.dubboserviceprovider.common;

import common.BizException;
import common.IErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class BizCheck {

    public static void falseThrow(boolean expression, IErrorCode errorCode, String errorMsg) {
        if (!expression) {
            log.error("{}:{}", errorCode, errorMsg);
            throw BizException.create(errorCode);
        }
    }

    public static void falseThrowPrompt(boolean expression, IErrorCode errorCode, String errorMsg) {
        if (!expression) {
            log.info("{}:{}", errorCode, errorMsg);
            if (StringUtils.isBlank(errorMsg)) {
                throw BizException.create(errorCode);
            } else {
                throw BizException.create(errorCode.getCode(), errorMsg);
            }
        }
    }

    public static void falseThrowPrompt(boolean expression, IErrorCode errorCode) {
        falseThrowPrompt(expression, errorCode, null);
    }

}
