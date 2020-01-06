package com.jintu.ipcdp.framework.api.redis;

import com.jintu.ipcdp.framework.api.redis.fallback.RedisApiFallback;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = JtServiceList.IPCDP_OPEN_SERVER_REDIS, path = "/redis", fallback = RedisApiFallback.class)
public interface RedisApi {

    @PostMapping("put")
    ResponseResult set(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("seconds") Long seconds);

    @GetMapping("del")
    ResponseResult del(@RequestParam("key") String key);

    @GetMapping("find")
    CommonResponseResult<String> find(@RequestParam("key") String key);

    @GetMapping("findLike")
    QueryResponseResult<String> findLike(@RequestParam("preKey") String preKey);
}
