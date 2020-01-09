package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.EmployeeDataRangeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindDataRangeByEmployeeIdResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/9 17:01
 * @Version 1.0
 */
@Component
public class EmployeeDataRangeControllerApiFallBack implements EmployeeDataRangeControllerApi {
    @Override
    public CommonResponseResult<FindDataRangeByEmployeeIdResponseDTO> findDataRangeByEmployeeId(Long employeeId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
