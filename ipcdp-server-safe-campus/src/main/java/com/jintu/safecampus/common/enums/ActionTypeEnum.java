package com.jintu.safecampus.common.enums;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 16:05
 * @Version 1.0
 */
public enum  ActionTypeEnum {
    /**
     * 增加 1、添加 2、修改 3、删除 4、查询
     */
    ADD(1, "注册"),
    UPDATE(2,"修改"),
    DELETE(3,"删除"),
    FIND(4,"查询"),
    OTHER(5,"其他操作");

    private final Integer value;
    private final String displayName;

    ActionTypeEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
