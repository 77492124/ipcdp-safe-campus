package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:30
 * @Version 1.0
 */
@Data
public class SaveAppVersionRequestDTO {

    /**
     * 版本文件 版本文件
     */
    @NotBlank(message = "版本文件不能为空")
    @ApiModelProperty("版本文件")
    private String versionFile;

    /**
     * 版本编号 版本编号
     */
    @NotBlank(message = "版本编号不能为空")
    @ApiModelProperty("版本编号")
    private String versionNumber;

    /**
     * 版本说明 版本说明
     */
    @NotBlank(message = "版本说明不能为空")
    @ApiModelProperty("版本说明")
    private String releaseNotes;

}
