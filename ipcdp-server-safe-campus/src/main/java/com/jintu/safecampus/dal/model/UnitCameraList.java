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
 * 单位摄像头列表 单位摄像头列表
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("unit_camera_list")
public class UnitCameraList implements Serializable {

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
     * 摄像头名称 摄像头名称
     */
    @TableField("camera_name")
    private String cameraName;

    /**
     * 摄像头类型 摄像头类型（0：人脸；1：车牌；2：热点；）
     */
    @TableField("camera_type")
    private Integer cameraType;

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
     * 阈值 阈值
     */
    @TableField("threshold")
    private BigDecimal threshold;

    /**
     * 在线标记 在线标记0：离线；1：在线；
     */
    @TableField("mark_online")
    private Boolean markOnline;

    /**
     * 创建人id
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
