package com.jintu.safecampus.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Parker
 * @Description: 自定义线程池
 * @Date 2020/1/6 16:46
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService taskExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("safe-campus-pool-%d").build();
        return new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>(200), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}
