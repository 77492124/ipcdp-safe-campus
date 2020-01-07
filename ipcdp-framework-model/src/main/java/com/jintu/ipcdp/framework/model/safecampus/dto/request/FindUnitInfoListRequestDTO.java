package com.jintu.ipcdp.framework.model.safecampus.dto.request;

import com.jintu.ipcdp.framework.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author Parker
 * @Description: @ToString(callSuper = true) 必须写，不然日志里的入参不显示
 * @Date 2020/1/6 17:33
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindUnitInfoListRequestDTO extends BaseRequest {

    /**
     * 单位名称 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitName;

    /**
     * 详细地址 详细地址
     */
    @ApiModelProperty("详细地址")
    private String unitAddress;

    /**
     * 单位管理员账号
     */
    @ApiModelProperty("单位管理员账号")
    private String userName;

}
