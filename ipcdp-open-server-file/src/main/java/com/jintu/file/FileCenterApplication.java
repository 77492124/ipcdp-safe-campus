package com.jintu.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文件中心
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@SpringBootApplication(scanBasePackages={"com.jintu.ipcdp.framework","com.jintu.file"})
@EnableDiscoveryClient
@EntityScan(basePackages = "com.jintu.ipcdp.framework.model.file")
public class FileCenterApplication {


	public static void main(String[] args) {
		SpringApplication.run(FileCenterApplication.class, args);
	}

}