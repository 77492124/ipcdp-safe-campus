package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Classname
 * @Description 护学岗任务出参
 * @Date 2020/1/16 15:33
 * @Created by lyx
 */
@Data
public class NursingPostTaskResponseDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("值班表id")
    private Long watchListId;

    /**
     * 护学岗时间id 护学岗时间id
     */
    @ApiModelProperty("护学岗时间id")
    private Long nursingPostTimeId;

    /**
     * 单位点位id 单位点位id
     */
    @ApiModelProperty("单位点位id")
    private Long unitPointId;

    /**
     * 点位名称 点位名称
     */
    @ApiModelProperty("点位名称")
    private String pointName;

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


}
