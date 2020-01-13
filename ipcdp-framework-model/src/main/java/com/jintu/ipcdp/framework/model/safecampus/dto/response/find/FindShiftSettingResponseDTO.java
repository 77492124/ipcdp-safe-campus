package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 10:58
 * @Version 1.0
 */
@Data
public class FindShiftSettingResponseDTO {

    /**
     * 护学岗时间id 护学岗时间id
     */
    @ApiModelProperty("护学岗时间id")
    private Long nursingPostTimeId;

    /**
     * 时间名称 时间名称
     */
    @ApiModelProperty("时间名称")
    private String timeName;

    /**
     * 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 开始时间 开始时间
     */
    @ApiModelProperty("开始时间")
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private LocalTime startingTime;

    /**
     * 结束时间 结束时间
     */
    @ApiModelProperty("结束时间")
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private LocalTime endTime;

    /**
     * 时间点位人员配置id，（点位需求设置id）
     */
    @ApiModelProperty("时间点位人员配置id(点位需求id)")
    private Long pointRequirementsSettingId;

    /**
     * 点位id
     */
    @ApiModelProperty("点位id")
    private Long unitPointId;

    /**
     * 点位名称 点位名称
     */
    @ApiModelProperty("点位名称")
    private String pointName;

    /**
     * 点位需求人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     * @JsonIgnore 转json时忽略
     */
    @JsonIgnore
    private Integer personType;

    /**
     * 人员数量 人员数量
     */
    @ApiModelProperty("人员数量")
    private Integer numberOfPersonnel;

    /**
     * 负责人列表
     */
    @ApiModelProperty("负责人列表")
    List<FindShiftSettingDTO> principals;

    /**
     * 点位值班日期
     */
    @ApiModelProperty("点位值班日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    List<LocalDate> pointDutyDates;


    /**
     * 护学岗人员列表
     */
    @ApiModelProperty("护学岗人员列表")
    List<FindShiftSettingDTO> nursingPostPersons;
}
