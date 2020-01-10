package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:09
 * @Version 1.0
 */
@Data
public class FindAlarmInfoListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("告警Id")
    private Long id;

    /**
     * 告警时间 告警时间
     */
    @ApiModelProperty("告警时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime alarmTime;


    /**
     * 告警类型 告警类型（0：脱岗；1：交通事故；2：不文明行为；3：热点告警；4：重点人员；5：重点车辆；6：热度；7：其他）
     */
    @ApiModelProperty("告警类型（0：脱岗；1：交通事故；2：不文明行为；3：热点告警；4：重点人员；5：重点车辆；6：热度；7：其他）")
    private Integer alarmType;

    /**
     * 告警说明 告警说明
     */
    @ApiModelProperty("告警说明")
    private String alarmDescription;


}
