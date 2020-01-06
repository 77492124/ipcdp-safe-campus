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
 * 学校系统资源表 学校系统资源表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("school_sys_resources")
public class SchoolSysResources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 上级id 上级id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 级别 级别
     */
    @TableField("level")
    private Integer level;

    /**
     * 资源名称 资源名称
     */
    @TableField("resource_name")
    private String resourceName;

    /**
     * 资源路径 资源路径
     */
    @TableField("resource_path")
    private String resourcePath;

    /**
     * 资源图标 资源图标
     */
    @TableField("resource_icon")
    private String resourceIcon;

    /**
     * 备注 备注
     */
    @TableField("remarks")
    private String remarks;

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
