package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.AlarmInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 11:07
 * @Version 1.0
 */
@Component
public class AlarmInfoControllerApiFallBack implements AlarmInfoControllerApi {
    @Override
    public QueryResponseResult<FindAlarmInfoListResponseDTO> findAlarmInfoList(FindAlarmInfoListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public CommonResponseResult<FindAlarmInfoByIdResponseDTO> findAlarmInfoById(Long alarmInfoId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
