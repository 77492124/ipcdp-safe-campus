package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:37
 * @Version 1.0
 */
@Data
public class FindUnitPointListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("点位id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 点位名称 点位名称
     */
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
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @ApiModelProperty("纬度")
    private BigDecimal latitude;
}
