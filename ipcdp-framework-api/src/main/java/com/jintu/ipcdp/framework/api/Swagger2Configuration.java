package com.jintu.ipcdp.framework.api;

import com.jintu.ipcdp.framework.properties.JintuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 王金海
 * @Title: Swagger2Configuration
 * @ProjectName ipcdp
 * @Description: TODO
 * @date 2019/4/2623:01
 */
@Configuration
@EnableSwagger2
public class  Swagger2Configuration {

    @Autowired
    private JintuProperties jintuProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(jintuProperties.getSwagger().getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(jintuProperties.getSwagger().getTitle())
                .description(jintuProperties.getSwagger().getDescription())
//                .termsOfServiceUrl("/")
                .version(jintuProperties.getSwagger().getVersion())
                .build();
    }
}
