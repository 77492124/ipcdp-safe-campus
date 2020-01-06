package com.jintu.safecampus.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Parker
 * @Description: METHOD 作用在方法上,RUNTIME 运行时注解,@Documented 表明这个注解应该被 javadoc工具记录
 * @Date 2019/12/30 17:48
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    //描述
    String description() default "" ;
    //操作的类型，1、添加 2、修改 3、删除 4、查询
    String actionType() default "" ;

}
