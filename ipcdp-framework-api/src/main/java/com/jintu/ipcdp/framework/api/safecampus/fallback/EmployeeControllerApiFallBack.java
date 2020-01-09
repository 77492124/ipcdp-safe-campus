package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.EmployeeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolResourcesListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 11:36
 * @Version 1.0
 */
@Component
public class EmployeeControllerApiFallBack implements EmployeeControllerApi {
    @Override
    public CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(EmployeeLoginRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public QueryResponseResult<FindEmployeeListResponseDTO> findEmployeeList(FindEmployeeListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveEmployee(SaveEmployeeRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<FindEmployeeByIdResponseDTO> findEmployeeById(Long employeeId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult editEmployee(EditEmployeeRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delEmployee(Long employeeId) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<FindSchoolResourcesListResponseDTO> findSchoolResourcesByEmployeeId(Long employeeId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
