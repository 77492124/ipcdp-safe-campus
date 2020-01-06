package com.jintu.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/23 9:05
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.jintu.authorization","com.jintu.ipcdp.framework"})
public class AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class,args);
    }
}
