package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/16 10:01
 * @Version 1.0
 */
@Data
public class UnitPointListDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("点位id")
    private Long id;

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

    /**
     * 在岗人数
     */
    @ApiModelProperty("在岗人数")
    private Integer numberOfEmployees;
}
