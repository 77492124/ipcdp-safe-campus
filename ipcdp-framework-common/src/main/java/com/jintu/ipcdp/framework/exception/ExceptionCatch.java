package com.jintu.ipcdp.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 统一异常捕获类
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:32
 **/
@RestControllerAdvice//控制器增强
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //定义map，配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    public ResponseResult customException(CustomException customException){
        customException.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}",customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }
    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception exception){
        exception.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}",exception.getMessage());
        if(EXCEPTIONS == null){
            EXCEPTIONS = builder.build();//EXCEPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if(resultCode !=null){
            return new ResponseResult(resultCode);
        }else{
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }


    }

    //捕获CustomException此类异常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseResult methodArgumentNotValidException(MethodArgumentNotValidException e){
//        e.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}",e.getMessage());
        StringBuffer sb = new StringBuffer();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError allError : fieldErrors) {
            String message = allError.getDefaultMessage();
            sb.append(message);
            if (fieldErrors.size()>1){
                sb.append("; ");
            }
        }
        return ResponseResult.FAILVALID(sb.toString());
    }
    // 参数非空异常捕获
    @ExceptionHandler({BindException.class})
    public ResponseResult methodArgumentNotValidException(BindException ex){
        LOGGER.error("catch BindException:{}",ex.getMessage());
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError allError : fieldErrors) {
            String message = allError.getDefaultMessage();
            sb.append(message);
            if (fieldErrors.size()>1){
                sb.append("; ");
            }
        }
        return ResponseResult.FAILVALID(sb.toString());
    }
    /**
     * 接收前端传参清除空格
     * @param binder
     */
    @InitBinder
    public void initBinder ( WebDataBinder binder )
    {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }



    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }
}
