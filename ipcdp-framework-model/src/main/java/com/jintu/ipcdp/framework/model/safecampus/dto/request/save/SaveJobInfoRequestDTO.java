package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 15:10
 * @Version 1.0
 */
@Data
public class SaveJobInfoRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 岗位名称 岗位名称
     */
    @NotBlank(message = "岗位名称不能为空")
    @ApiModelProperty("岗位名称")
    private String jobName;

    /**
     * 岗位说明 岗位说明
     */
    @ApiModelProperty("岗位说明")
    private String jobDescription;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "创建人不能为空")
    @ApiModelProperty("创建人（当前用户id）")
    private Long createdId;
}
