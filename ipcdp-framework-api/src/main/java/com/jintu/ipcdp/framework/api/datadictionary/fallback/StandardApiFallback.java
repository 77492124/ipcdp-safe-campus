package com.jintu.ipcdp.framework.api.datadictionary.fallback;

import com.jintu.ipcdp.framework.api.datadictionary.StandardApi;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dell on 2019/5/9.
 */
@Component
public class StandardApiFallback implements StandardApi {

    @Override
    public QueryResponseResult<StandardResponse> findByFlag(@RequestParam("flag") Integer flag) {

        return new QueryResponseResult(CommonCode.SERVER_ANOMALY, null);
    }

    @Override
    public QueryResponseResult<StandardDirectoryResponse> findStandardFlags() {

        return new QueryResponseResult(CommonCode.SERVER_ANOMALY, null);
    }
}
