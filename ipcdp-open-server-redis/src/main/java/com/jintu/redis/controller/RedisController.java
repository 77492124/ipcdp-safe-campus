package com.jintu.redis.controller;

import com.jintu.ipcdp.framework.api.redis.RedisApi;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.*;
import com.jintu.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2018/8/31.
 * @Modified By:
 */
@Api(tags = "redis操作")
@RestController
@Slf4j
public class RedisController implements RedisApi {


    @Autowired
    private RedisService redisService;

    @ApiOperation("保存")
    @Override
    public ResponseResult set(String key, String value, Long seconds) {
        log.info("redis保存");
        redisService.set(key, value, seconds);
        return ResponseResult.SUCCESS();
    }

    @ApiOperation("删除")
    @Override
    public ResponseResult del(String key) {
        if (StringUtils.isEmpty(key)) {
            ExceptionCast.cast("Key不能为空");
        }
        log.info("redis删除");
        redisService.del(key);
        return ResponseResult.SUCCESS();
    }


    @ApiOperation("通过key获取值")
    @Override
    public CommonResponseResult<String> find(String key) {
        log.info("redis通过key获取值");
        if (StringUtils.isEmpty(key)) {
            ExceptionCast.cast("key不能为空");
        }
        String json = null;

        Object obj = redisService.get(key);
        if (obj == null) {
            ExceptionCast.cast("值为空");
        }
        json = String.valueOf(obj);
        return new CommonResponseResult<String>(CommonCode.SUCCESS,json);
    }
    @ApiOperation("通过key前缀获取值")
    @Override
    public QueryResponseResult<String> findLike(String preKey) {
        log.info("redis通过key前缀获取值");
        if (StringUtils.isEmpty(preKey)) {
            ExceptionCast.cast("preKey不能为空");
        }
        List<Object> redisServiceLike = redisService.findLike(preKey);
        if (redisServiceLike==null) {
            ExceptionCast.cast("值为空");
        }
        List<String> strings=new ArrayList<>();
        redisServiceLike.forEach(s->strings.add(String.valueOf(s)));
        QueryResult<String> objectQueryResult = new QueryResult<String>();
        objectQueryResult.setData(strings);
        objectQueryResult.setTotal((long)redisServiceLike.size());
        return new QueryResponseResult<String>(CommonCode.SUCCESS, objectQueryResult);
    }
}
