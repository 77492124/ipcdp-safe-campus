package com.jintu.redis.service;

import java.util.List;

public interface RedisService {
    /**
     * set
     * @param key   key
     * @param value     value
     * @param seconds   秒
     */
    void set(String key, Object value, long seconds);

    /**
     * del
     * @param key   key
     */
    void del(String key);
    /**
     * 获取单个
     * @param key key
     * @return Object
     */
    Object get(String key);

    /**
     * 匹配前缀获取set集合
     * @param preKey    Key前缀
     * @return set集合
     */
    List<Object> findLike(String preKey);
}