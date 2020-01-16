package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Description 护学岗登录入参
 * @Date 2020/1/16 11:47
 * @Created by lyx
 */
@Data
public class NursingPostPersonLoginRequestDTO {
    /**
     * 账号 账号(手机号)
     */
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(" 账号(手机号)")
    private String userName;

    /**
     * 密码 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(" 密码")
    private String passWord;
}
