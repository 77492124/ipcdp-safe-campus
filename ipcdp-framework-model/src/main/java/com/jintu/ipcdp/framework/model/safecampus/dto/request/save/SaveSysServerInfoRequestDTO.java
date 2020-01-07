package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 15:17
 * @Version 1.0
 */
@Data
public class SaveSysServerInfoRequestDTO {
    /**
     * 服务器名称 服务器名称
     */
    @NotBlank(message = "服务器名称不能为空")
    @ApiModelProperty("服务器名称")
    private String serverName;

    /**
     * 服务器类型 服务器类型(0：互联网服务器；1：视频专网服务器；2：边界服务器；3：视频点播服务器)
     */
    @NotNull(message = "服务器类型不能为空")
    @ApiModelProperty("服务器类型(0：互联网服务器；1：视频专网服务器；2：边界服务器；3：视频点播服务器)")
    private Integer serverType;

    /**
     * ip地址 ip地址
     */
    @NotBlank(message = "ip地址不能为空")
    @ApiModelProperty("ip地址")
    private String ipAddress;

    /**
     * 端口号 端口号
     */
    @NotBlank(message = "端口号不能为空")
    @ApiModelProperty("端口号")
    private String portNumber;
}
