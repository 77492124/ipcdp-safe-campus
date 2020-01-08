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
 * @Date 2020/1/8 12:01
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindJobInfoListRequestDTO extends BaseRequest {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 岗位名称 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String jobName;
}
