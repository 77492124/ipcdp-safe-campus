package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 11:39
 * @Version 1.0
 */
@Data
public class EmployeeLoginResponseDTO {
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

    /**
     * 用户人员权限树
     */
    @ApiModelProperty("用户人员权限树")
    private List<SchoolSysResourcesDTO> schoolSysResources;
}
