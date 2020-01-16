package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/16 9:34
 * @Version 1.0
 */
@Data
public class FindWorkInRealTimeStaffResponseDTO {

    /**
     * 单位点位列表
     */
    @ApiModelProperty("单位点位列表")
    private List<UnitPointListDTO> pointList;

    /**
     * 上班人员列表
     */
    @ApiModelProperty("上班人员列表")
    private List<WorkInRealTimeStaffDTO> workInRealTimeStaffList;


}
