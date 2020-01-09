package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 14:08
 * @Version 1.0
 */
@Data
public class SaveEmployeeRequestDTO {
    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 岗位id
     */
    @NotEmpty(message = "岗位不能为空")
    @ApiModelProperty("岗位id集合")
    private List<Long> jobInfoIds;

    /**
     * 员工姓名 员工姓名
     */
    @NotBlank(message = "员工姓名不能为空")
    @ApiModelProperty("员工姓名")
    private String employeeName;

    /**
     * 性别 0：女；1：男；
     */
    @NotBlank(message = "性别不能为空")
    @ApiModelProperty("性别 0：女；1：男；")
    private Integer gender;

    /**
     * 电话号码 电话号码
     */
    @ApiModelProperty("电话号码")
    private String telephone;

    /**
     * 账号 账号
     */
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty("账号")
    private String userName;

    /**
     * 密码 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String passWord;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "登录用户id不能为空")
    @ApiModelProperty("登录用户id")
    private Long createdId;
}
