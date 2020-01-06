package com.jintu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by dell on 2019/5/9.
 */
@SpringBootApplication(scanBasePackages = {"com.jintu.demo","com.jintu.ipcdp.framework"})
@EntityScan(basePackages = "com.jintu.ipcdp.framework.model.datadictionary")
@EnableDiscoveryClient
public class DataDictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataDictionaryApplication.class, args);
    }

}
