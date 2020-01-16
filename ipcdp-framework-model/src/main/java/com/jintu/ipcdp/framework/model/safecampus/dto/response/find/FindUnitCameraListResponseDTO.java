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
    @ApiModelProperty("唯一标识ID")
    private Long id;

    /**
     * 摄像头名称 摄像头名称
     */
    @ApiModelProperty("摄像头名称")
    private String cameraName;

    /**
     * 摄像头类型 摄像头类型（0：人脸；1：车牌；2：热点；）
     */
    @ApiModelProperty("摄像头类型（0：人脸；1：车牌；2：热点；）")
    private Integer cameraType;

    /**
     * 经度 经度
     */
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    /**
     * 在线标记 在线标记0：离线；1：在线；
     */
    @ApiModelProperty("在线标记0：离线；1：在线")
    private Boolean markOnline;




}
