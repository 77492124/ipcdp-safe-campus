package com.jintu.ipcdp.framework.model.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode{
    INVALID_PARAM(false,10003,"非法参数！"),
    SUCCESS(true,10000,"操作成功！"),
    SUCCFAIL(true,10001,"批量操作有失败！"),
    FAIL(false,11111,"操作失败！"),
    WECHATFAIL(false,10004,"微信第三方异常！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    NETWORK_ANOMALY(false,11001,"网络异常,请稍后再试"),
    SERVER_ANOMALY(false,88888,"下游服务器异常,请稍后再试"),
    UNAUTHORIZED(false,30000,"系统未授权"),
    UNREGISTER(false,30001,"用户未注册"),
    WECHAT_UNBOUNDED(false,40000,"微信未绑定"),
    INQUIRY_IS_EMPTY(false,10005,"查询数据为空！");

//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
