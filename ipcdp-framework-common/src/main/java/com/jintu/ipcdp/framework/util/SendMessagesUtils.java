package com.jintu.ipcdp.framework.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 常培兵
 * @Description: 发送短信
 * @Date 2019/8/15 13:58
 * @Version 1.0
 */
@Slf4j
public class SendMessagesUtils {

    /**
     * 创蓝账号
     */
    private static final String ACCOUNT = "N8054208";
    /**
     * 创蓝密码
     */
    private static final String PASSWORD = "3isJAzlr6";

    /**
     * 验证码发送
     * @param code 验证码
     * @param phone 手机号
     * @return 返回信息
     */
    public static ResponseResult verificationCode(String code, String phone){
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> map = new HashMap<>();
        map.put("account",ACCOUNT);
        map.put("password",PASSWORD);
        String msg = "【Modern社区】您手机验证码是%s,5分钟有效，如非本人操作则忽略。";
        map.put("msg",String.format(msg,code));
        map.put("phone",phone);
        JsonNode result = restTemplate.postForObject("http://smssh1.253.com/msg/send/json", map, JsonNode.class);
        System.out.println(result);
        String resultCode = result.get("code").asText();
        if (!"0".equals(resultCode)){
            log.error("短信验证码发送出错，参数:{},返回:{}",map,result.asText("null"));
            ResponseResult.FAILVALID(result.get("errorMsg").asText());
        }
        return ResponseResult.SUCCESS();
    }

    /**
     * 验证码发送
     * @param code 验证码
     * @param phone 手机号
     * @param appName app名称
     * @return 返回信息
     */
    public static ResponseResult verificationCode(String code, String phone, String appName){
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> map = new HashMap<>();
        map.put("account",ACCOUNT);
        map.put("password",PASSWORD);
        String msg = "【%s】您手机验证码是%s,5分钟有效，如非本人操作则忽略。";
        map.put("msg",String.format(msg,appName,code));
        map.put("phone",phone);
        JsonNode result = restTemplate.postForObject("http://smssh1.253.com/msg/send/json", map, JsonNode.class);
        String resultCode = result.get("code").asText();
        if (!"0".equals(resultCode)){
            log.error("短信验证码发送出错，参数:{},返回:{}",map,result.asText("null"));
            ResponseResult.FAILVALID(result.get("errorMsg").asText());
        }
        return ResponseResult.SUCCESS();
    }

    public static void main(String[] args) {
        System.out.println(verificationCode("584562","13186150814"));
        //System.out.println();
    }
}
