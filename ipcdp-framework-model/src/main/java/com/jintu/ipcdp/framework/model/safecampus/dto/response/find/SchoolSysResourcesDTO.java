package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author Parker
 * @Description: 权限资源树
 * @Date 2020/1/9 9:03
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class SchoolSysResourcesDTO {
    /**
     * 唯一标识ID 唯一标识ID
     */
     @ApiModelProperty("资源权限id")
    private Long id;

    /**
     * 上级id 上级id
     */
     @ApiModelProperty("上级id")
    private Long parentId;

    /**
     * 级别 级别
     */
     @ApiModelProperty("级别")
    private Integer level;

    /**
     * 资源名称 资源名称
     */
     @ApiModelProperty("资源名称")
    private String resourceName;

    /**
     * 资源路径 资源路径
     */
     @ApiModelProperty("资源路径")
    private String resourcePath;

    /**
     * 资源图标 资源图标
     */
     @ApiModelProperty("资源图标")
    private String resourceIcon;

    /**
     * 备注 备注
     */
     @ApiModelProperty("备注")
    private String remarks;

    /**
     * 子集
     */
    @ApiModelProperty("子集")
    private List<SchoolSysResourcesDTO> childList;
}
