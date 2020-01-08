package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Parker
 * @Description: 岗位授权请求
 * @Date 2020/1/8 16:25
 * @Version 1.0
 */
@Data
public class JobAuthorizeRequestDTO {

    /**
     * 岗位id
     */
    @NotNull(message = "岗位id不能为空")
    @ApiModelProperty("岗位id")
    private Long id;

    /**
     * 学校系统资源id 岗位权限id
     */
    @NotEmpty(message = "岗位权限id集合不能为空")
    @ApiModelProperty("岗位权限id集合")
    private List<Long> schoolSysResourcesIds;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "创建人不能为空")
    @ApiModelProperty("创建人（当前用户id）")
    private Long createdId;
}
