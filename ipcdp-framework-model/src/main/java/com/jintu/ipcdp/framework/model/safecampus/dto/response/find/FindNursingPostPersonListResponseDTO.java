package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 15:30
 * @Version 1.0
 */
@Data
public class FindNursingPostPersonListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("护学岗人员id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 人员姓名 人员姓名
     */
    @ApiModelProperty("人员姓名")
    private String personName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @ApiModelProperty("人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）")
    private Integer personType;

    /**
     * 账号 账号(手机号)
     */
    @ApiModelProperty("账号(手机号)")
    private String userName;

    /**
     * 密码 密码
     */
    @ApiModelProperty("密码")
    private String passWord;

    /**
     * 设备号 设备号
     */
    @ApiModelProperty("设备号")
    private String deviceNo;

    /**
     * 设备访问地址 设备访问地址
     */
    @ApiModelProperty("设备访问地址")
    private String accessAddress;

    /**
     * 佩戴标记 0：否；1：是；
     */
    @ApiModelProperty("佩戴标记 0：否；1：是；")
    private Boolean wearMark;
}
