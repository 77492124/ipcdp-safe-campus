package com.jintu.ipcdp.framework.model.datadictionary.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 文婧瑶
 * @Description: 省市区返回数据
 * @Date: 10:38 2019/5/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DprocityregionResponse {
    /**
     * DID
     */
    private Long dId;

    /**
     * 省市区名称
     */
    private String dName;

    /**
     * 上级ID
     */
    private Long dParentid;

    private List<DprocityregionResponse> dprocityregionBeans;

    public DprocityregionResponse(Long dId, String dName, Long dParentid) {
        this.dId = dId;
        this.dName = dName;
        this.dParentid = dParentid;
    }
}
