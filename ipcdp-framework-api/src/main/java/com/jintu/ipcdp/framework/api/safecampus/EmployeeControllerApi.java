package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.EmployeeControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 员工信息API
 * @Date 2020/1/8 11:35
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/employee/", fallback = EmployeeControllerApiFallBack.class)
public interface EmployeeControllerApi {

    /**
     * 学校员工登录
     * @param requestDTO 登录信息
     * @return 员工信息
     */
    @PostMapping("employeeLogin")
    CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(@Validated @RequestBody EmployeeLoginRequestDTO requestDTO);

    //QueryResponseResult<> findEmployeeList();


}
