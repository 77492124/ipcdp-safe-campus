package com.jintu.ipcdp.framework.model.redis;

/**
 * @Author 岳保保
 * @Description:
 * @Date 2019/10/23
 * @Version 1.0
 */
public enum RedisKeyEnum {
    /**
     * 停车入场队列prefix ENTER_entranceId_parkingNo_cameraId
     */
    REDIS_PREFIX_ENTER("ENTER"),

    /**
     * 停车出场队列prefix EXIT_entranceId_parkingNo_cameraId
     */
    REDIS_PREFIX_EXIT("EXIT");

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    RedisKeyEnum(String prefix) {
        this.prefix = prefix;
    }
}
