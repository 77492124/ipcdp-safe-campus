package com.jintu.safecampus.dal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表 员工信息表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @TableField("unit_info_id")
    private Long unitInfoId;

    /**
     * 员工姓名 员工姓名
     */
    @TableField("employee_name")
    private String employeeName;

    /**
     * 性别 0：女；1：男；
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 电话号码 电话号码
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 账号 账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码 密码
     */
    @TableField("pass_word")
    private String passWord;

    /**
     * 管理员标记 管理员标记0：否；1：是；
     */
    @TableField("admin_mark")
    private Boolean adminMark;

    /**
     * 创建人id 创建人id（员工id）
     */
    @TableField("created_id")
    private Long createdId;

    /**
     * 是否删除 0：未删除；1：已删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间 创建时间
     */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
