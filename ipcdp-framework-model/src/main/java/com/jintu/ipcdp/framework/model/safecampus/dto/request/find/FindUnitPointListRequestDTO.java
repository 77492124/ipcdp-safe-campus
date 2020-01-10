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
 * @Date 2020/1/10 11:36
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindUnitPointListRequestDTO extends BaseRequest {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位ID不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;
}
