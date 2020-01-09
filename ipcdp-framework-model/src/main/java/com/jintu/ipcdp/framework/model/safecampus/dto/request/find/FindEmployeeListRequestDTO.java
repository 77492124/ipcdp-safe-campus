package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.jintu.ipcdp.framework.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 11:53
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindEmployeeListRequestDTO extends BaseRequest {

    /**
     * 当前用户id
     */
    @NotNull(message = "当前用户id不能为空")
    @ApiModelProperty("当前用户id")
    private Long userId;

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 员工姓名 员工姓名
     */
    @ApiModelProperty("员工姓名")
    private String employeeName;

    /**
     * 岗位id
     */
    @ApiModelProperty("岗位id")
    private Long jobInfoId;
}
