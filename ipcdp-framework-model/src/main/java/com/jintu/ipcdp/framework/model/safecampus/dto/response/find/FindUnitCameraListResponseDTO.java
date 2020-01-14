package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Classname
 * @Description 查询单位摄像头
 * @Date 2020/1/14 9:12
 * @Created by lyx
 */
@Data
public class FindUnitCameraListResponseDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("服务器Id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("服务器Id")
    private Long unitInfoId;

    /**
     * 摄像头名称 摄像头名称
     */
    @ApiModelProperty("服务器Id")
    private String cameraName;

    /**
     * 摄像头类型 摄像头类型（0：人脸；1：车牌；2：热点；）
     */
    @ApiModelProperty("服务器Id")
    private Integer cameraType;

    /**
     * 经度 经度
     */
    @ApiModelProperty("服务器Id")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @ApiModelProperty("服务器Id")
    private BigDecimal latitude;

    /**
     * 阈值 阈值
     */
    @ApiModelProperty("服务器Id")
    private BigDecimal threshold;

    /**
     * 在线标记 在线标记0：离线；1：在线；
     */
    @ApiModelProperty("服务器Id")
    private Boolean markOnline;

    /**
     * 创建人id
     */
    @ApiModelProperty("服务器Id")
    private Long createdId;

    /**
     * 是否删除 0：未删除；1：已删除
     */
    @ApiModelProperty("服务器Id")
    private Integer deleted;

    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("服务器Id")
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    @ApiModelProperty("服务器Id")
    private LocalDateTime updatedTime;

}
