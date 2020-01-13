package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.PointRequirementsPersonnelControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 10:27
 * @Version 1.0
 */
@Component
public class PointRequirementsPersonnelApiFallBack implements PointRequirementsPersonnelControllerApi {

    @Override
    public QueryResponseResult<FindShiftSettingResponseDTO> findShiftSetting(Long nursingPostTimeId) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveShiftSetting(List<SaveShiftSettingRequestDTO> requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
