package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Classname
 * @Description 护学岗人员脱岗记录出参
 * @Date 2020/1/17 10:24
 * @Created by lyx
 */
@Data
public class NursingPostPersonUnWorkRecordResponseDTO {

    /**
     * 工作日期 工作日期
     */
    @ApiModelProperty("工作日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate workingDate;

    /**
     * 时间名称 时间名称
     */
    @ApiModelProperty("时间名称")
    private String timeName;

    /**
     * 开始时间 开始时间
     */
    @ApiModelProperty("开始时间")
    @JsonFormat(pattern="HH:mm:ss",timezone="GMT+8")
    private LocalTime startingTime;

    /**
     * 结束时间 结束时间
     */
    @ApiModelProperty("结束时间")
    @JsonFormat(pattern="HH:mm:ss",timezone="GMT+8")
    private LocalTime endTime;

    /**
     * 点位名称
     */
    @ApiModelProperty("工作地点")
    private String pointName;
}
