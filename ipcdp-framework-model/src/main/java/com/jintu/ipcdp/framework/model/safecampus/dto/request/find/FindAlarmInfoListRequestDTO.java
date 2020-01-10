package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.jintu.ipcdp.framework.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:08
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindAlarmInfoListRequestDTO extends BaseRequest {

    /**
     * 单位id 单位id
     */
    @ApiModelProperty("单位id")
    private Long unitInfoId;
}
