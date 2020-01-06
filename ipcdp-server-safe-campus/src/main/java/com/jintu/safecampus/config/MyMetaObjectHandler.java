package com.jintu.safecampus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author 常培兵
 * @Description: MybatisPlus全局自动填充
 * @Date 2019/8/15 15:25
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler  {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleted",0,metaObject);
        LocalDateTime now = LocalDateTime.now();
        this.setFieldValByName("createdTime",now,metaObject);
        this.setFieldValByName("updatedTime",now,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now();
        this.setFieldValByName("updatedTime",now,metaObject);
    }
}
