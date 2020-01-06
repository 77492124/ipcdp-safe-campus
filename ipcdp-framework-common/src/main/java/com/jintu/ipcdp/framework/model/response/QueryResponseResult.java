package com.jintu.ipcdp.framework.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel(value = "全局响应")
@NoArgsConstructor
public class QueryResponseResult<T> extends ResponseResult implements Serializable {

    @ApiModelProperty(value = "数据列表")
    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult<T> queryResult){
        super(resultCode);
        this.queryResult = queryResult;
    }
    public QueryResponseResult(QueryResult<T> queryResult){
        super(CommonCode.SUCCESS);
        this.queryResult = queryResult;
    }
    public QueryResponseResult(ResultCode resultCode){
        super(resultCode);
        this.queryResult = null;
    }

    public static QueryResponseResult SERVER_ANOMALY(){
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
