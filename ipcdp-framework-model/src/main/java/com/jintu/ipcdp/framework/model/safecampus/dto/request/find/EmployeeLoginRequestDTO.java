package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 11:39
 * @Version 1.0
 */
@Data
public class EmployeeLoginRequestDTO {

    /**
     * 用户名
     */
    @Size(max = 11,message = "用户名不能大于11位")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码")
    @ApiModelProperty("用户名")
    private String passWord;
}
