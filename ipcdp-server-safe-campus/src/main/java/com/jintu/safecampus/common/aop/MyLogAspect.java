package com.jintu.safecampus.common.aop;

import com.google.gson.Gson;
import com.jintu.ipcdp.framework.exception.CustomException;
import com.jintu.safecampus.common.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/30 18:00
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class MyLogAspect {


    @Around("@annotation(com.jintu.safecampus.common.annotation.MyLog)")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        String resultStr = null;
        boolean bool = false;
        try {
            // 执行方法
            result = point.proceed();
            resultStr = new Gson().toJson(result);
        } catch (Throwable e) {
            e.printStackTrace();
            if (e instanceof CustomException) {
                CustomException e1 = (CustomException) e;
                resultStr = e1.getResultCode().message();
                log.error("记录操作日志发生异常：{}",resultStr);
            }
            bool = true;
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time, resultStr,bool);
        return result;
    }


    /**
     * 组装系统日志格式并保存
     * @param joinPoint 环绕对象
     * @param time 方法执行时间
     * @param resultStr 方法执行返回值
     * @param errorMark 方法执行是否异常
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time, String resultStr, boolean errorMark) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        MyLog logAnnotation = method.getAnnotation(MyLog.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.description());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
            }
            sysLog.setParams(params.toString());
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String userId = request.getHeader("userId");
        int operationSource = request.getIntHeader("operation_source");
        // 设置IP地址
        sysLog.setIp(this.getIpAddress(request));
        // 模拟一个用户名
        sysLog.setTime((int) time);
        sysLog.setCreateTime(new Date());
        // 保存系统日志
        System.out.println("userid:"+userId+",operationSource:"+operationSource);
        System.out.println("日志："+sysLog.toString());
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
     private String getIpAddress(HttpServletRequest request) {
             String ip = request.getHeader("x-forwarded-for");
             if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                     ip = request.getHeader("Proxy-Client-IP");
                 }
             if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                     ip = request.getHeader("WL-Proxy-Client-IP");
                 }
             if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                     ip = request.getHeader("HTTP_CLIENT_IP");
                 }
             if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                     ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                 }
             if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                     ip = request.getRemoteAddr();
                 }
             return ip;
     }
}
