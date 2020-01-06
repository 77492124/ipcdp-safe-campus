package com.jintu.ipcdp.framework.exception;


import com.jintu.ipcdp.framework.model.response.ResultCode;

/**
 * 自定义异常类型
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:28
 **/
public class CustomException extends RuntimeException{

    //错误代码
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public CustomException(boolean success,int code, String message){
        this.resultCode = new ResultCode() {
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
        };
    }


    public ResultCode getResultCode(){
        return resultCode;
    }


}
