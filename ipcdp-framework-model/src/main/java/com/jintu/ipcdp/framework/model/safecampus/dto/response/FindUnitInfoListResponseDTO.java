package com.jintu.ipcdp.framework.model.safecampus.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 17:34
 * @Version 1.0
 */
@Data
public class FindUnitInfoListResponseDTO {

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
     * 单位类型 0：学校；1：平安办；
     */
    @ApiModelProperty("单位类型 0：学校；1：平安办；")
    private Integer unitType;

    /**
     * 详细地址 详细地址
     */
    @ApiModelProperty("详细地址")
    private String unitAddress;

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
     * 单位管理员账号
     */
    @ApiModelProperty("单位管理员账号")
    private String userName;

    /**
     * 单位管理员密码
     */
    @ApiModelProperty("单位管理员密码")
    private String passWord;
}
