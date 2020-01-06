package com.jintu.govern.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/4/25.
 * @Modified By:
 */
@Configuration
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class GovernAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernAdminApplication.class,args);
    }
}
