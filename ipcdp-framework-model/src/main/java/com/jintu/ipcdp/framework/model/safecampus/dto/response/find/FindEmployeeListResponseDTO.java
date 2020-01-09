package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 11:54
 * @Version 1.0
 */
@Data
public class FindEmployeeListResponseDTO {

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
     * 性别 0：女；1：男；
     */
    @ApiModelProperty("性别 0：女；1：男；")
    private Integer gender;


    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String jobName;
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
     * 管理员标记 管理员标记0：否；1：是；
     */
    @ApiModelProperty("管理员标记0：否；1：是；")
    private Boolean adminMark;
}
