package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Classname
 * @Description 查询服务器列表
 * @Date 2020/1/13 17:30
 * @Created by lyx
 */
@Data
public class FindUnitServerInfoListResponseDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("唯一标识ID")
    private Long id;

    /**
     * 服务器名称 服务器名称
     */
    @ApiModelProperty("服务器名称")
    private String serverName;

    /**
     * 服务器类型 服务器类型(0：互联网服务器；1：视频专网服务器；2：边界服务器；3：视频点播服务器)
     */
    @ApiModelProperty("服务器类型(0：互联网服务器；1：视频专网服务器；2：边界服务器；3：视频点播服务器)")
    private Integer serverType;

    /**
     * ip地址 ip地址
     */
    @ApiModelProperty("ip地址")
    private String ipAddress;

    /**
     * 端口号 端口号
     */
    @ApiModelProperty("端口号")
    private String portNumber;


}
