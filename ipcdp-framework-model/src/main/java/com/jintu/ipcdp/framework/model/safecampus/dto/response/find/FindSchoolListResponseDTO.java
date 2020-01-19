package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 查询学校列表信息出参
 * @Date 2020/1/6 17:34
 * @Version 1.0
 */
@Data
public class FindSchoolListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("单位id")
    private Long id;

    /**
     * 单位名称 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitName;

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
