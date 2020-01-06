package com.jintu.govern.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/4/25.
 * @Modified By:
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.jintu.govern.zuul","com.jintu.ipcdp.framework","com.jintu.ipcdp.framework.api"})
public class GovernZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernZuulApplication.class,args);
    }




}
