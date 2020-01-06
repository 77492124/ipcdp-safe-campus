package com.jintu.ipcdp.framework.model.datadictionary.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 文婧瑶
 * @Description: 标准bean
 * @Date: 16:43 2018/1/30
 */
@Data
public class StandardResponse {

    @ApiModelProperty("id")
    private Integer standardId;

    @ApiModelProperty("code")
    private String code;

    @ApiModelProperty("名称")
    private String standardContent;

    public StandardResponse() {
    }

    public StandardResponse(Integer standardId, String code, String standardContent) {
        this.standardId = standardId;
        this.code = code;
        this.standardContent = standardContent;
    }
}
