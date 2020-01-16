package com.jintu.safecampus.dal.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 护学岗人员 护学岗人员表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nursing_post_person")
public class NursingPostPerson implements Serializable {

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
     * 人员姓名 人员姓名
     */
    @TableField("person_name")
    private String personName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @TableField("person_type")
    private Integer personType;

    /**
     * 账号 账号(手机号)
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码 密码
     */
    @TableField("pass_word")
    private String passWord;

    /**
     * 设备号 设备号
     */
    @TableField("device_no")
    private String deviceNo;

    /**
     * 设备访问地址 设备访问地址
     */
    @TableField("access_address")
    private String accessAddress;

    /**
     * 佩戴标记 0：否；1：是；
     */
    @TableField("wear_mark")
    private Boolean wearMark;

    /**
     * 在岗状态 0：脱岗；1：在岗；
     */
    @TableField("post_status")
    private Boolean postStatus;

    /**
     * 上班状态 0：下班；1：上班；
     */
    @TableField("work_status")
    private Boolean workStatus;

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
