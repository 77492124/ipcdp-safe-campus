package com.jintu.ipcdp.framework.model;

/**
 * @Classname VerificationCodeEnm
 * @Description 短信验证码枚举
 * @Date 2019/11/27 10:58
 * @Created by wjh
 */

public enum  VerificationCodeEnum {
    PARKING("易美停车","ymtc");

    private String codePrefix;

    private String redisPrefix;

    VerificationCodeEnum(String codePrefix, String redisPrefix) {
        this.codePrefix = codePrefix;
        this.redisPrefix = redisPrefix;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public String getRedisPrefix() {
        return redisPrefix;
    }

    public void setRedisPrefix(String redisPrefix) {
        this.redisPrefix = redisPrefix;
    }
}
