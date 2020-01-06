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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 单位信息表 单位信息表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("unit_info")
public class UnitInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 单位名称 单位名称
     */
    @TableField("unit_name")
    private String unitName;

    /**
     * 单位类型 0：学校；1：平安办；
     */
    @TableField("unit_type")
    private Integer unitType;

    /**
     * 详细地址 详细地址
     */
    @TableField("unit_address")
    private String unitAddress;

    /**
     * 经度 经度
     */
    @TableField("longitude")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @TableField("latitude")
    private BigDecimal latitude;

    /**
     * 创建人id 创建人id（系统管理员id）
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
