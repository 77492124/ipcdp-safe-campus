package com.jintu.ipcdp.framework.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "全局响应数据")
public class QueryResult<T> implements Serializable {
    /**
     * 数据列表
     */
    @ApiModelProperty(value = "数据")
    private List<T> data;

    /**
     * 数据总数
     */
    @ApiModelProperty(value = "数据总数")
    private Long total;

}
