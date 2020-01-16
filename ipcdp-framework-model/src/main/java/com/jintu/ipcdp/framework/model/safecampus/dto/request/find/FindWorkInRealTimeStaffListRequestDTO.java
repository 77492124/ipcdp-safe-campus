package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/16 9:33
 * @Version 1.0
 */
@Data
public class FindWorkInRealTimeStaffListRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位ID不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;


}
