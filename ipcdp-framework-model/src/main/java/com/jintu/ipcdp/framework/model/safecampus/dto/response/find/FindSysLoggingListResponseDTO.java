package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:49
 * @Version 1.0
 */
@Data
public class FindSysLoggingListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("唯一标识ID")
    private Long id;

    /**
     * 操作类型 1、添加 2、修改 3、删除 4、查询
     */
    @ApiModelProperty("操作类型 1、添加 2、修改 3、删除 4、查询")
    private Integer actionType;

    /**
     * 操作人Id 操作人Id(根据操作来源不同，查询方式不同)
     */
    @ApiModelProperty("操作人")
    private String operationName;

    /**
     * 操作来源 用户来源 1:管理员端；2：学校端；3：平安办端
     */
    @ApiModelProperty("操作来源 1:管理员端；2：学校端；3：平安办端")
    private Integer operationSource;

    /**
     * 操作描述 操作描述
     */
    @ApiModelProperty("操作描述")
    private String description;

    /**
     * 运行方法 运行方法
     */
    @ApiModelProperty("运行方法")
    private String runMethod;

    /**
     * 请求参数 请求参数
     */
    @ApiModelProperty("请求参数")
    private String params;

    /**
     * 返回参数 返回参数
     */
    @ApiModelProperty("返回参数")
    private String result;

    /**
     * ip地址 ip地址
     */
    @ApiModelProperty("ip地址")
    private String ipAddress;

    /**
     * 运行时长 运行时长（毫秒）
     */
    @ApiModelProperty("运行时长（毫秒）")
    private Long runTime;

    /**
     * 是否运行错误 是否运行错误；0：正常；1：出错；
     */
    @ApiModelProperty("是否运行错误；0：正常；1：出错；")
    private Boolean errorMark;
}
