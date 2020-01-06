package com.jintu.ipcdp.framework.model.datadictionary.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dell on 2019/4/3.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardDirectoryResponse {

    @ApiModelProperty("id(即flag)")
    private Integer standardFlag;

    @ApiModelProperty("下拉列表类别")
    private String standardName;

}
