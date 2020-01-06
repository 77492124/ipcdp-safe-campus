package com.jintu.authorization.config.exception;

import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.util.MapperUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Parker
 * @Description: 无效 token 异常类重写
 * @Date 2019/12/25 10:01
 * @Version 1.0
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        String json = MapperUtils.obj2json(new ResponseResult(false,401,"token失效"));
        response.getWriter().write(json);
    }
}
