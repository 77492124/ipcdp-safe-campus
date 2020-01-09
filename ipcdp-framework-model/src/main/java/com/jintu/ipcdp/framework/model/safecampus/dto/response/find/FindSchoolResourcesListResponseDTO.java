package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 16:16
 * @Version 1.0
 */
@Data
public class FindSchoolResourcesListResponseDTO {

    /**
     * 用户人员权限树
     */
    @ApiModelProperty("用户人员权限树")
    private List<SchoolSysResourcesDTO> schoolSysResources;
}
