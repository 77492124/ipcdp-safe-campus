package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/15 15:36
 * @Version 1.0
 */
@Data
public class FindWatchListByIdResponseDTO {

    /**
     * 人员数量 人员数量
     */
    @ApiModelProperty("人员数量")
    private Integer numberOfPersonnel;

    /**
     * 护学岗人员列表
     */
    @ApiModelProperty("护学岗人员列表")
    List<FindShiftSettingDTO> nursingPostPersons;

    /**
     * 负责人列表
     */
    @ApiModelProperty("负责人列表")
    List<FindShiftSettingDTO> principals;
}
