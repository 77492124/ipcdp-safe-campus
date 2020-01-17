package com.jintu.ipcdp.framework.model.safecampus.dto.request.edit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/15 14:13
 * @Version 1.0
 */
@Data
public class EditWatchListRequestDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @NotNull(message = "值班id不能为空")
    @ApiModelProperty("值班id")
    private Long id;

    /**
     * 负责人id集合
     */
    @NotEmpty(message = "负责人id集合不能为空")
    @ApiModelProperty("负责人id集合(护学岗人员id)")
    private List<Long> principalIds;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty("创建人id(当前登录用户id)")
    private Long createdId;
}
