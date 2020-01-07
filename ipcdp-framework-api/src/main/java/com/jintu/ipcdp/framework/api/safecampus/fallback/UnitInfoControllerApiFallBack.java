package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.UnitInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.FindUnitInfoListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 17:31
 * @Version 1.0
 */
@Component
public class UnitInfoControllerApiFallBack implements UnitInfoControllerApi {
    @Override
    public QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
