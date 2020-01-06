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
 * 告警表 告警信息表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("alarm_info")
public class AlarmInfo implements Serializable {

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
    private String unitInfoId;

    /**
     * 告警时间 告警时间
     */
    @TableField("alarm_time")
    private LocalDateTime alarmTime;

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
     * 告警类型 告警类型（0：脱岗；1：交通事故；2：不文明行为；3：热点告警；4：重点人员；5：重点车辆；6：热度；7：其他）
     */
    @TableField("alarm_type")
    private Integer alarmType;

    /**
     * 告警图片 告警图片
     */
    @TableField("alarm_picture")
    private String alarmPicture;

    /**
     * 告警说明 告警说明
     */
    @TableField("alarm_description")
    private String alarmDescription;

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
