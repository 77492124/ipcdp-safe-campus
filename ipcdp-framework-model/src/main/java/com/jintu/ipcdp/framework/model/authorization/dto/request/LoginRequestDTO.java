package com.jintu.ipcdp.framework.model.authorization.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/24 10:40
 * @Version 1.0
 */
@Data
public class LoginRequestDTO {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty("账号")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String passWord;


}
