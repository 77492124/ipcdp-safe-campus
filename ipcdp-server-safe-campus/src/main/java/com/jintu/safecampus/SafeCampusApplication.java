package com.jintu.safecampus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 11:18
 * @Version 1.0
 */
@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.jintu.safecampus.dal.dao")
@SpringBootApplication(scanBasePackages = {"com.jintu.safecampus","com.jintu.ipcdp.framework"})
public class SafeCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafeCampusApplication.class,args);
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
