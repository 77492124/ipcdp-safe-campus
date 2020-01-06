package com.jintu.ipcdp.framework.properties.bean;

import lombok.Data;

/**
 * @author 王金海
 * @Title: Swaggerp
 * @ProjectName ipcdp
 * @Description: TODO
 * @date 2019/4/270:43
 */

@Data
public class SwaggerProperties {
    private String basePackage="com.jintu";
    private String title="锦途API接口";
    private String description="锦途接口文档说明";
    private String version="1.0";
}
