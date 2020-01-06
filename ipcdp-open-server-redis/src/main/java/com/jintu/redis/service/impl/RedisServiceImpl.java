package com.jintu.redis.service.impl;

import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2018/8/31.
 * @Modified By:
 */
@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, Object value, long seconds) {
        if (seconds>0) {
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        }else {
            redisTemplate.opsForValue().set(key, value, seconds);
        }


    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Object get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o==null) {
            ExceptionCast.cast("值为空");
        }
        return o;
    }

    @Override
    public List<Object> findLike(String preKey) {
        Set<String> keys = redisTemplate.keys(preKey+"*");
        if (keys!=null) {
            return redisTemplate.opsForValue().multiGet(keys);
        }
        return null;
    }
}
