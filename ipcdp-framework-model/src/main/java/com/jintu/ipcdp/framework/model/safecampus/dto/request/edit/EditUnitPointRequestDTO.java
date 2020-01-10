package com.jintu.ipcdp.framework.model.safecampus.dto.request.edit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:55
 * @Version 1.0
 */
@Data
public class EditUnitPointRequestDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @NotNull(message = "点位id不能为空")
    @ApiModelProperty("点位id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 点位名称 点位名称
     */
    @NotBlank(message = "点位名称不能为空")
    @ApiModelProperty("点位名称")
    private String pointName;

    /**
     * 点位说明 点位说明
     */
    @ApiModelProperty("点位说明")
    private String pointDescription;

    /**
     * 经度 经度
     */
    @NotNull(message = "经度不能为空")
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @NotNull(message = "纬度不能为空")
    @ApiModelProperty("纬度")
    private BigDecimal latitude;
}
