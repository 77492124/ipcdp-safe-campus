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
 * 员工岗位关系表 员工岗位关系表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employee_job_relation")
public class EmployeeJobRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 员工id 员工id
     */
    @TableField("employee_id")
    private Long employeeId;

    /**
     * 岗位id 岗位id
     */
    @TableField("job_info_id")
    private Long jobInfoId;

    /**
     * 创建人id 创建人id
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
