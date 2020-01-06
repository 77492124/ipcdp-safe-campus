package com.jintu.ipcdp.framework.properties;

import com.jintu.ipcdp.framework.properties.bean.FileAliyunProperties;
import com.jintu.ipcdp.framework.properties.bean.FileLocalProperties;
import com.jintu.ipcdp.framework.properties.bean.SwaggerProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * @author 王金海
 * @Title: JintuProperties
 * @ProjectName ipcdp
 * @Description: TODO
 * @date 2019/4/271:12
 */
@Component
@ConfigurationProperties(prefix = "com.jintu")
@Data
public class JintuProperties {

    @NestedConfigurationProperty
    private SwaggerProperties swagger=new SwaggerProperties();
    @NestedConfigurationProperty
    private FileLocalProperties fileLocal=new FileLocalProperties();
    @NestedConfigurationProperty
    private FileAliyunProperties fileAliyun=new FileAliyunProperties();

}
