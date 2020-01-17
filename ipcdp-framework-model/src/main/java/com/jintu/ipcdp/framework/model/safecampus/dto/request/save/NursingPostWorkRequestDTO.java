package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Description 护学岗上下班入参
 * @Date 2020/1/17 9:04
 * @Created by lyx
 */
@Data
public class NursingPostWorkRequestDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @NotNull(message = "值班表id不能为空")
    @ApiModelProperty("值班表id")
    private Long watchListId;

    @NotNull(message = "护学岗人员id不能为空")
    @ApiModelProperty("护学岗人员id")
    private Long nursingPostPersonId;

    /**
     * 记录类型 0：下班；1：上班；；
     */
    @NotNull(message = "记录类型不能为空")
    @ApiModelProperty("记录类型 0：下班；1：上班")
    private Integer recordType;
}
