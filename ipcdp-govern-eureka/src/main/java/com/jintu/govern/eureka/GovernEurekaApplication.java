package com.jintu.govern.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 王金海
 * @Description: 管理-注册中心
 * @Date: Created by Administrator on 2019/4/25.
 * @Modified By:
 */
@EnableEurekaServer
@SpringBootApplication
public class GovernEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernEurekaApplication.class,args);
    }
}
