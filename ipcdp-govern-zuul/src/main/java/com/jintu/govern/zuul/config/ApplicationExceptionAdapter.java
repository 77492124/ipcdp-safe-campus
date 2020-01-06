package com.jintu.govern.zuul.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 王金海
 * @Title: ApplicationExceptionAdapter
 * @ProjectName ipcdp
 * @Description: TODO
 * @date 2019/4/270:13
 */
//@Configuration
public class ApplicationExceptionAdapter implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //自定义 serviceId 和路由之间的相互映射
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper() {
//        return new PatternServiceRouteMapper(
//                "(?<project>^.+)-(?<subProject>.+$)",
//                "${project}-${subProject}");
//    }
}
