package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.UnitInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
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

    @Override
    public ResponseResult saveUnitInfo(SaveUnitInfoRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<EditUnitInfoResponseDTO> editUnitInfo(EditUnitInfoRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public CommonResponseResult<EditUnitInfoResponseDTO> findUnitInfoById(Long unitInfoId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult delUnitInfo(Long unitInfoId) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public QueryResponseResult<FindSchoolListResponseDTO> findSchoolList(String unitName) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
