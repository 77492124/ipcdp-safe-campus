package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 16:17
 * @Version 1.0
 */
@Data
public class SaveNursingPostPersonRequestDTO {
    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 人员姓名 人员姓名
     */
    @NotBlank(message = "人员姓名不能为空")
    @ApiModelProperty("人员姓名")
    private String personName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @NotNull(message = "人员类型不能为空")
    @ApiModelProperty("人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）")
    private Integer personType;

    /**
     * 账号 账号(手机号)
     */
    @Size(max = 11,message = "账号不能大于11位")
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty("账号(手机号)")
    private String userName;

    /**
     * 密码 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String passWord;

    /**
     * 设备号 设备号
     */
    @NotBlank(message = "设备号不能为空")
    @ApiModelProperty("设备号")
    private String deviceNo;

    /**
     * 设备访问地址 设备访问地址
     */
    @NotBlank(message = "设备访问地址不能为空")
    @ApiModelProperty("设备访问地址")
    private String accessAddress;

    /**
     * 佩戴标记 0：否；1：是；
     */
    @NotNull(message = "佩戴标记不能为空")
    @ApiModelProperty("佩戴标记 0：否；1：是；")
    private Boolean wearMark;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "登录用户id不能为空")
    @ApiModelProperty("当前登录用户id")
    private Long createdId;
}
