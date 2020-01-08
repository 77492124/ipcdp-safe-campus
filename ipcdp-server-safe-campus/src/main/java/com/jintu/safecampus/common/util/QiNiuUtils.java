package com.jintu.safecampus.common.util;

import com.qiniu.util.Auth;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Parker
 * @Description: 七牛云文件上传工具
 * @Date 2020/1/8 10:13
 * @Version 1.0
 */
@Component
public class QiNiuUtils {

    /**
     * key
     */
    public static final String ACCESS_KEY = "7_A8vWFwAqwbT9a43rrmDAxZpPMVCIbA4ncYBeDO";

    /**
     * 秘钥
     */
    public static final String SECRET_KEY  = "qxy1l0TIcdg4K--y9IoDH187ZkKdHaEFEIsOgfMT";
    /**
     * 七牛空间名称
     */
    public static final String BUCKET  = "jintu-school";

    /**
     * 毫秒格式化时间
     */
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    /**
     * 保存获取时间及token，避免每次都向七牛云获取。
     */
    public static LocalDateTime getUpTokenTime = null;
    public static String token = null;




    /**
     * 获取上传token
     * @return token
     */
    public String getUpToken(){
        if (getUpTokenTime == null) {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            getUpTokenTime = LocalDateTime.now();
            token = auth.uploadToken(BUCKET, null, 3600, null, true);
            return token;
        }
        Duration duration = Duration.between(getUpTokenTime, LocalDateTime.now());
        long minutes = duration.toMinutes();
        if (minutes > 58) {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            getUpTokenTime = LocalDateTime.now();
            token = auth.uploadToken(BUCKET, null, 3600, null, true);
            return token;
        }
        return token;
    }

    /**
     * 获取文件名称
     * @param suffix 文件后缀（扩展名）
     * @return 文件名称
     */
    public String getFileName(String suffix){
        return String.format("%s_%s%s.%s", suffix, LocalDateTime.now().format(MILLISECOND), RandomStringUtils.randomAlphabetic(5), suffix);
    }
}
