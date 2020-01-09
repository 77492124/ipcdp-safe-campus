package com.jintu.ipcdp.framework.model.safecampus.dto.request.edit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 15:36
 * @Version 1.0
 */
@Data
public class EditEmployeeRequestDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("员工id")
    private Long id;

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
