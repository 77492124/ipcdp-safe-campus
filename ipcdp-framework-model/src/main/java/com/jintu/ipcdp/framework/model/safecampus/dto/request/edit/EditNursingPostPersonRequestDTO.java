package com.jintu.ipcdp.framework.model.safecampus.dto.request.edit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 16:29
 * @Version 1.0
 */
@Data
public class EditNursingPostPersonRequestDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @NotNull(message = "护学岗人员id不能为空")
    @ApiModelProperty("护学岗人员id")
    private Long id;

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

}
