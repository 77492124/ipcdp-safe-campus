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
 * 系统日志表 系统操作日志表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_logging")
public class SysLogging implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 操作类型 1、添加 2、修改 3、删除 4、查询
     */
    @TableField("action_type")
    private Integer actionType;

    /**
     * 操作人Id 操作人Id(根据操作来源不同，查询方式不同)
     */
    @TableField("operation_id")
    private Long operationId;

    /**
     * 操作来源 用户来源 1:管理员端；2：学校端；3：平安办端
     */
    @TableField("operation_source")
    private Integer operationSource;

    /**
     * 操作描述 操作描述
     */
    @TableField("description")
    private String description;

    /**
     * 运行方法 运行方法
     */
    @TableField("run_method")
    private String runMethod;

    /**
     * 请求参数 请求参数
     */
    @TableField("params")
    private String params;

    /**
     * 返回参数 返回参数
     */
    @TableField("result")
    private String result;

    /**
     * ip地址 ip地址
     */
    @TableField("ip_address")
    private String ipAddress;

    /**
     * 运行时长 运行时长（毫秒）
     */
    @TableField("run_time")
    private Long runTime;

    /**
     * 是否运行错误 是否运行错误；0：正常；1：出错；
     */
    @TableField("error_mark")
    private Boolean errorMark;

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
