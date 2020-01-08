package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import com.jintu.safecampus.dal.model.Employee;

/**
 * <p>
 * 员工表 员工信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * 学校员工登录
     * @param requestDTO 登录信息
     * @return 员工信息
     */
    CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(EmployeeLoginRequestDTO requestDTO);
}
