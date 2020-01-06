package com.jintu.ipcdp.framework.api.datadictionary;

import com.jintu.ipcdp.framework.api.datadictionary.fallback.StandardApiFallback;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dell on 2019/4/2.
 */
@FeignClient(name = JtServiceList.IPCDP_OPEN_SERVER_DATADICTIONARY,path = "datadictionary/standard/",fallback = StandardApiFallback.class)
public interface StandardApi {

    @GetMapping("findByFlag")
    QueryResponseResult<StandardResponse> findByFlag(@RequestParam("flag") Integer flag);

    @GetMapping("findStandardFlags")
    QueryResponseResult<StandardDirectoryResponse> findStandardFlags();

}
