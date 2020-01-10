package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalTime;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 16:49
 * @Version 1.0
 */
@Data
public class FindNursingPostTimeListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("护学岗时间Id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

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
