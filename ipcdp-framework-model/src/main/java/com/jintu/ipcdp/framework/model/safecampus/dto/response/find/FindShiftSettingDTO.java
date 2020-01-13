package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 11:24
 * @Version 1.0
 */
@Data
public class FindShiftSettingDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("护学岗人员id")
    private Long id;

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
}
