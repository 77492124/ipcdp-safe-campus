package com.jintu.ipcdp.framework.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/4/4.
 * @Modified By:
 */
@Data
@NoArgsConstructor
public class CommonResponseResult<T> extends ResponseResult implements Serializable {

    private T data;

    public CommonResponseResult(ResultCode resultCode, T data) {
        super(resultCode);
        this.data = data;
    }
    public CommonResponseResult( T data) {
        super(CommonCode.SUCCESS);
        this.data = data;
    }
    public CommonResponseResult(ResultCode resultCode) {
        super(resultCode);
    }

    public static CommonResponseResult FAIL() {
        return new CommonResponseResult(CommonCode.FAIL);
    }
    public static CommonResponseResult SERVER_ANOMALY() {
        return new CommonResponseResult(CommonCode.SERVER_ANOMALY);
    }
}
