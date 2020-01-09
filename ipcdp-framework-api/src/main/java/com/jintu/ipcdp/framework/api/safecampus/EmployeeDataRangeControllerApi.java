package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.EmployeeDataRangeControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindDataRangeByEmployeeIdResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Parker
 * @Description: 员工数据范围API
 * @Date 2020/1/9 17:01
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/employee-data-range/", fallback = EmployeeDataRangeControllerApiFallBack.class)
public interface EmployeeDataRangeControllerApi {

    /**
     * 根据员工id查询数据范围
     * @param employeeId 员工id
     * @return 数据范围
     */
    @GetMapping("findDataRange/{employeeId}")
    CommonResponseResult<FindDataRangeByEmployeeIdResponseDTO> findDataRangeByEmployeeId(@PathVariable("employeeId") Long employeeId);


}
