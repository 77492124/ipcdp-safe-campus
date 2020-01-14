package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.UnitCameraListControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Description
 * @Date 2020/1/14 9:03
 * @Created by lyx
 */
@Component
public class UnitCameraListControllerApiFallBack implements UnitCameraListControllerApi {
    @Override
    public QueryResponseResult<FindUnitCameraListResponseDTO> findUnitCameraList(FindUnitPointListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
