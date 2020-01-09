package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 14:57
 * @Version 1.0
 */
@Data
public class FindEmployeeByIdResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("员工id")
    private Long id;

    /**
     * 员工姓名 员工姓名
     */
    @ApiModelProperty("员工姓名")
    private String employeeName;

    /**
     * 员工岗位id集合
     */
    @ApiModelProperty("员工岗位id集合")
    private List<Long> jobInfoIds;

    /**
     * 性别 0：女；1：男；
     */
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
    @ApiModelProperty("账号")
    private String userName;

    /**
     * 密码 密码
     */
    @ApiModelProperty("密码")
    private String passWord;

}
