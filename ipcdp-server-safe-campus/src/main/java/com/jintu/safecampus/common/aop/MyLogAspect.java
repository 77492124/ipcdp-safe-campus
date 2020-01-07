package com.jintu.safecampus.common.aop;

import com.google.gson.Gson;
import com.jintu.ipcdp.framework.exception.CustomException;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.dal.model.SysLogging;
import com.jintu.safecampus.service.ISysLoggingService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

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

    @Resource
    private ISysLoggingService sysLoggingService;

    @Resource
    private ExecutorService executorService;

    @Around("@annotation(com.jintu.safecampus.common.annotation.MyLog)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
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
            }else {
                resultStr = e.getMessage();
            }
            bool = true;
            throw e;
        }finally {
            // 执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            // 保存日志
            saveLog(point, time, resultStr,bool);
        }
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
        SysLogging sysLogging = new SysLogging();
        MyLog logAnnotation = method.getAnnotation(MyLog.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLogging.setActionType(logAnnotation.actionType().getValue());
            sysLogging.setDescription(logAnnotation.description());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogging.setRunMethod(className + "." + methodName + "()");
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
            sysLogging.setParams(params.toString());
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        // 获取请求头的参数
        String userId = request.getHeader("userId");
        String operationSource = request.getHeader("operation_source");
        // 设置IP地址
        sysLogging.setIpAddress(this.getIpAddress(request));
        sysLogging.setResult(resultStr);
        sysLogging.setRunTime(time);
        sysLogging.setErrorMark(errorMark);
        sysLogging.setOperationId(userId == null ? null : Long.valueOf(userId));
        sysLogging.setOperationSource(operationSource == null ? null : Integer.valueOf(operationSource));
        // 保存系统日志
        log.info("保存日志:{}",sysLogging);
        // 异步将Log添加数据库
        CompletableFuture.runAsync(() -> {
            try {
                sysLoggingService.save(sysLogging);
                log.info("【添加至数据库】：{}", sysLogging);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        },executorService);
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
