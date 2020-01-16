package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.PointRequirementsPersonnelControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingBaseResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 10:27
 * @Version 1.0
 */
@Component
public class PointRequirementsPersonnelApiFallBack implements PointRequirementsPersonnelControllerApi {

    @Override
    public CommonResponseResult<FindShiftSettingBaseResponseDTO> findShiftSetting(FindShiftSettingRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveShiftSetting(SaveShiftSettingBaseRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
