package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 11:39
 * @Version 1.0
 */
@Data
public class SafeEmployeeLoginResponseDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("员工id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitInfoName;

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
