package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 12:42
 * @Version 1.0
 */
@Data
public class FindJobInfoListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("岗位id")
    private Long id;

    /**
     * 岗位名称 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String jobName;

    /**
     * 岗位说明 岗位说明
     */
    @ApiModelProperty("岗位说明")
    private String jobDescription;
}
