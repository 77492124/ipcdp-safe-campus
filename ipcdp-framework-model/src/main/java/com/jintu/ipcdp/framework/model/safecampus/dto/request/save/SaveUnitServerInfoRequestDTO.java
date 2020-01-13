package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Classname
 * @Description 增加服务器
 * @Date 2020/1/13 18:01
 * @Created by lyx
 */
@Data
public class SaveUnitServerInfoRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

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
    @ApiModelProperty("服务器类型")
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

    /**
     * 在线标记 在线标记0：离线；1：在线；
     */
    @NotNull(message = "在线标记不能为空")
    @ApiModelProperty("在线标记0：离线；1：在线 ")
    private Boolean markOnline;

    /**
     * 创建人id
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty("创建人id")
    private Long createdId;


}
