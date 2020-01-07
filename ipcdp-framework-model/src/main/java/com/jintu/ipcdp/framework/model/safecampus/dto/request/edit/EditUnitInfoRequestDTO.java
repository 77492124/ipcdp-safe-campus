package com.jintu.ipcdp.framework.model.safecampus.dto.request.edit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 10:34
 * @Version 1.0
 */
@Data
public class EditUnitInfoRequestDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long id;

    /**
     * 单位名称 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitName;

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
     * 单位管理员id
     */
    @NotNull(message = "单位管理员id不能为空")
    @ApiModelProperty("单位管理员id")
    private Long employeeId;

    /**
     * 单位管理员密码
     */
    @Size(max = 16,message = "管理员密码不能大于16位")
    @ApiModelProperty("单位管理员密码")
    private String passWord;
}
