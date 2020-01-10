package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:22
 * @Version 1.0
 */
@Data
public class FindAlarmInfoByIdResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("告警id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitInfoName;

    /**
     * 告警时间 告警时间
     */
    @ApiModelProperty("告警时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime alarmTime;

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
     * 告警类型 告警类型（0：脱岗；1：交通事故；2：不文明行为；3：热点告警；4：重点人员；5：重点车辆；6：热度；7：其他）
     */
    @ApiModelProperty("告警类型（0：脱岗；1：交通事故；2：不文明行为；3：热点告警；4：重点人员；5：重点车辆；6：热度；7：其他）")
    private Integer alarmType;

    /**
     * 告警图片 告警图片
     */
    @ApiModelProperty("告警图片")
    private String alarmPicture;

    /**
     * 告警说明 告警说明
     */
    @ApiModelProperty("告警说明")
    private String alarmDescription;
}
