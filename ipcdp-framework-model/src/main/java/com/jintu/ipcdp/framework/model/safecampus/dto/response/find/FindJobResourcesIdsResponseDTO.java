package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 16:01
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class FindJobResourcesIdsResponseDTO {

    /**
     * 学校系统资源id 岗位权限id
     */
    @ApiModelProperty("岗位权限id")
    private Long schoolSysResourcesId;


}
