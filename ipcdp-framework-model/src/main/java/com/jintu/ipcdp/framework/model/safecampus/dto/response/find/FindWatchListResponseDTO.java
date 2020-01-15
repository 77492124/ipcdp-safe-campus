package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 17:20
 * @Version 1.0
 */
@Data
public class FindWatchListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("值班id")
    private Long id;

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
     * 点位名称 点位名称
     */
    @ApiModelProperty("点位名称")
    private String pointName;

    /**
     * 负责人列表
     */
    @ApiModelProperty("负责人列表")
    private List<FindWatchListDTO> principalList;
}
