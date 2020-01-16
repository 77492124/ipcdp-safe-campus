package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/16 10:04
 * @Version 1.0
 */
@Data
public class WorkInRealTimeStaffDTO {

    /**
     * 人员姓名 人员姓名
     */
    @ApiModelProperty("人员姓名")
    private String personName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @ApiModelProperty("人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）")
    private Integer personType;

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
     * 在岗状态 0：脱岗；1：在岗；
     */
    @ApiModelProperty("在岗状态 0：脱岗；1：在岗；")
    private Boolean postStatus;
}
