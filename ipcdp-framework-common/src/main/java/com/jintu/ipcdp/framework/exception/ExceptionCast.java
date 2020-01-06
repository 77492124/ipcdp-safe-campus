package com.jintu.ipcdp.framework.exception;


import com.jintu.ipcdp.framework.model.response.ResultCode;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:31
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

    public static void cast(String message){
        throw new CustomException(false,11111,message);
    }
    public static void cast(String message,int code){
        throw new CustomException(false,code,message);
    }

}
