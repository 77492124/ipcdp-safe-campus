package com.jintu.authorization.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.jintu.ipcdp.framework.api.authorization.UsersControllerApi;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.authorization.dto.request.LoginRequestDTO;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Parker
 * @Description: 用户接口
 * @Date 2019/12/23 9:06
 * @Version 1.0
 */
@Api(tags = "用户接口 ")
@RestController
@RequestMapping("/users")
public class UsersController implements UsersControllerApi {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private TokenStore tokenStore;

    @ApiOperation(value = "登录接口", response = ResponseResult.class)
    @Override
    public CommonResponseResult<String> login(LoginRequestDTO requestDTO) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDTO.getUserName());
        if (userDetails == null || !passwordEncoder.matches(requestDTO.getPassWord(),userDetails.getPassword())) {
            ExceptionCast.cast("账号或密码错误！");
        }
        String url = "http://localhost:8080/authorization/oauth/token";
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        //  也支持中文
        params.add("username", requestDTO.getUserName());
        params.add("password", requestDTO.getPassWord());
        params.add("grant_type", "password");
        params.add("client_id", "client");
        params.add("client_secret", "secret");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<JsonNode> response = client.postForEntity(url, requestEntity , JsonNode.class);
        JsonNode body = response.getBody();
        return new CommonResponseResult<>(body.get("access_token").asText());
    }

    @ApiOperation(value = "获取用户信息", response = ResponseResult.class)
    @Override
    public CommonResponseResult<Map<String, String>> info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            System.out.println(new ObjectMapper().writeValueAsString(authentication));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String name = authentication.getName();
        return new CommonResponseResult<>(new HashMap<String, String>(2){{put("name",name);put("avatar","http://b-ssl.duitang.com/uploads/item/201703/06/20170306012959_aH4Ki.jpeg");}});
    }

    @ApiOperation(value = "注销", response = ResponseResult.class)
    @Override
    public ResponseResult logout(String accessToken) {
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return ResponseResult.SUCCESS();
    }
}
