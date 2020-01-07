package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 9:09
 * @Version 1.0
 */
@Data
public class SaveUnitInfoRequestDTO {

    /**
     * 单位名称 单位名称
     */
    @NotBlank(message = "单位名称不能为空")
    @ApiModelProperty("单位名称")
    private String unitName;

    /**
     * 单位类型 0：学校；1：平安办；
     */
    @NotNull(message = "单位类型不能为空")
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
    @NotNull(message = "经度不能为空")
    @ApiModelProperty("经度")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @NotNull(message = "纬度不能为空")
    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    /**
     * 单位管理员账号
     */
    @Size(max = 11,message = "管理员账号不能大于11位")
    @NotBlank(message = "管理员账号不能为空")
    @ApiModelProperty("单位管理员账号")
    private String userName;

    /**
     * 单位管理员密码
     */
    @Size(max = 16,message = "管理员密码不能大于16位")
    @NotBlank(message = "管理员密码不能为空")
    @ApiModelProperty("单位管理员密码")
    private String passWord;

    /**
     * 创建人id 创建人id（系统管理员id）
     */
    @NotNull(message = "当前登录用户id不能为空")
    @ApiModelProperty("当前登录用户id")
    private Long createdId;
}
