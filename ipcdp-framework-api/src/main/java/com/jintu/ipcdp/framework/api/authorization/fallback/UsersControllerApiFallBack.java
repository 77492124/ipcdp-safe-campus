package com.jintu.ipcdp.framework.api.authorization.fallback;

import com.jintu.ipcdp.framework.api.authorization.UsersControllerApi;
import com.jintu.ipcdp.framework.model.authorization.dto.request.LoginRequestDTO;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/24 10:35
 * @Version 1.0
 */
@Component
public class UsersControllerApiFallBack implements UsersControllerApi {
    @Override
    public CommonResponseResult<String> login(LoginRequestDTO requestDTO) {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<Map<String, String>> info() {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult logout(String accessToken) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
