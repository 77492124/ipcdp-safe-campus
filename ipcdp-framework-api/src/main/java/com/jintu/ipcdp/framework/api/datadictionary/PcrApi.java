package com.jintu.ipcdp.framework.api.datadictionary;

import com.jintu.ipcdp.framework.api.datadictionary.fallback.PcrApiFallback;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by dell on 2019/4/2.
 */
@FeignClient(name = JtServiceList.IPCDP_OPEN_SERVER_DATADICTIONARY,path = "datadictionary/pcr/",fallback = PcrApiFallback.class)
public interface PcrApi {

    @GetMapping("findPcr")
    QueryResponseResult<DprocityregionResponse> procityregion();

}
