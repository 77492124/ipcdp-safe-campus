package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.SysLoggingControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:46
 * @Version 1.0
 */
@Component
public class SysLoggingControllerApiFallBack implements SysLoggingControllerApi {
    @Override
    public QueryResponseResult<FindSysLoggingListResponseDTO> findSysLoggingList(FindSysLoggingListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
