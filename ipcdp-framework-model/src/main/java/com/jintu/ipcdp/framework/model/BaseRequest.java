package com.jintu.ipcdp.framework.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author 常培兵
 * @Description: 通用分页请求对象
 * @Date 2019/3/16 16:25
 * @Version 1.0
 */
@Data
public abstract class BaseRequest {
    /**
     * 当前页
     */
    @NotNull(message = "当前页码不能为空")
    @ApiModelProperty(value = "当前页码")
    private Long current;
    /**
     * 每页显示条数
     */
    @NotNull(message = "每页显示条数不能为空")
    @ApiModelProperty(value = "每页显示条数")
    private Long size;

}
