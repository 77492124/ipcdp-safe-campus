package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Classname
 * @Description 单位摄像头添加入参
 * @Date 2020/1/14 9:47
 * @Created by lyx
 */
@Data
public class SaveUnitCameraRequestDTO {
    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;
    /**
     * 摄像头名称 摄像头名称
     */
    @NotBlank(message = "摄像头名称不能为空")
    @ApiModelProperty("摄像头名称")
    private String cameraName;

    /**
     * 摄像头类型 摄像头类型（0：人脸；1：车牌；2：热点；）
     */
    @NotNull(message = "摄像头类型不能为空")
    @ApiModelProperty("摄像头类型（0：人脸；1：车牌；2：热点；）")
    private Integer cameraType;

    /**
     * 经度 经度
     */
    @NotNull(message = "经度不能为空")
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @NotNull(message = "纬度不能为空")
    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    /**
     * 阈值 阈值
     */
    @ApiModelProperty("阈值")
    private BigDecimal threshold;

    /**
     * 创建人id
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty("创建人id")
    private Long createdId;
}
