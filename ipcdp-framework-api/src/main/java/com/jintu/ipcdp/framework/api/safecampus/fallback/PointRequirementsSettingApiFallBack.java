package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.PointRequirementsSettingControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditPointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 9:01
 * @Version 1.0
 */
@Component
public class PointRequirementsSettingApiFallBack implements PointRequirementsSettingControllerApi {
    @Override
    public QueryResponseResult<FindPointSettingListResponseDTO> findPointRequirementsSettingList(Long nursingPostTimeId) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult savePointRequirementsSetting(SavePointRequirementsSettingRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult editPointRequirementsSetting(EditPointRequirementsSettingRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delPointRequirementsSetting(Long id) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
