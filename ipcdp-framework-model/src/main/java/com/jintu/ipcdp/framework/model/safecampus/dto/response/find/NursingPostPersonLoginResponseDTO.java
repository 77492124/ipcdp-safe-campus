package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Classname
 * @Description 护学岗人员登录出参
 * @Date 2020/1/16 11:34
 * @Created by lyx
 */
@Data
public class NursingPostPersonLoginResponseDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("唯一标识ID")
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

}
