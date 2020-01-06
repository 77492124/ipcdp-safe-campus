package com.jintu.ipcdp.framework.api.redis.fallback;

import com.jintu.ipcdp.framework.api.redis.RedisApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import org.springframework.stereotype.Component;

@Component
public class RedisApiFallback implements RedisApi {
    @Override
    public ResponseResult set(String key, String value, Long seconds) {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult del(String key) {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<String> find(String key) {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public QueryResponseResult<String> findLike(String preKey) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
