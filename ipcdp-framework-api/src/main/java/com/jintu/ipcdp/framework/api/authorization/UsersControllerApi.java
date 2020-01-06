package com.jintu.ipcdp.framework.api.authorization;

import com.jintu.ipcdp.framework.api.authorization.fallback.UsersControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.authorization.dto.request.LoginRequestDTO;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/24 10:31
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_OPEN_SERVER_AUTHORIZATION, path = "/authorization/users/", fallback = UsersControllerApiFallBack.class)
public interface UsersControllerApi {

    /**
     * 登录接口
     * @param requestDTO
     * @return
     */
    @PostMapping("login")
    CommonResponseResult<String> login(@Validated @RequestBody LoginRequestDTO requestDTO);

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    CommonResponseResult<Map<String,String>> info();

    /**
     * 注销
     * @param accessToken
     * @return
     */
    @PostMapping("logout")
    ResponseResult logout(@RequestParam("access_token") String accessToken);
}
