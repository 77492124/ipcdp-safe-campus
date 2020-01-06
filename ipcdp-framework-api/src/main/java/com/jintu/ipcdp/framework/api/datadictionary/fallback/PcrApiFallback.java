package com.jintu.ipcdp.framework.api.datadictionary.fallback;

import com.jintu.ipcdp.framework.api.datadictionary.PcrApi;
import com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2019/5/9.
 */
@Component
public class PcrApiFallback implements PcrApi {

    @Override
    public QueryResponseResult<DprocityregionResponse> procityregion() {

        return new QueryResponseResult(CommonCode.SERVER_ANOMALY, null);
    }
}
