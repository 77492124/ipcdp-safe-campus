package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.*;
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
    /**
     * 查询学校员工列表
     * @param requestDTO 查询条件
     * @return 员工列表
     */
    QueryResponseResult<FindEmployeeListResponseDTO> findEmployeeList(FindEmployeeListRequestDTO requestDTO);
    /**
     * 新增员工
     * @param requestDTO 员工信息
     * @return 是否成功
     */
    ResponseResult saveEmployee(SaveEmployeeRequestDTO requestDTO);
    /**
     * 根据id查询学校员工详情
     * @param employeeId 员工id
     * @return 员工详情
     */
    CommonResponseResult<FindEmployeeByIdResponseDTO> findEmployeeById(Long employeeId);
    /**
     * 编辑学校员工
     * @param requestDTO 员工信息
     * @return 是否成功
     */
    ResponseResult editEmployee(EditEmployeeRequestDTO requestDTO);

    /**
     * 删除学校员工
     * @param employeeId 员工id
     * @return 是否成功
     */
    ResponseResult delEmployee(Long employeeId);
    /**
     * 查询学校员工的权限树
     * @param employeeId 员工id
     * @return 权限树
     */
    CommonResponseResult<FindSchoolResourcesListResponseDTO> findSchoolResourcesByEmployeeId(Long employeeId);

    /**
     * 平安办员工登录
     * @param requestDTO
     * @return
     */
    CommonResponseResult<SafeEmployeeLoginResponseDTO> safeEmployeeLogin(EmployeeLoginRequestDTO requestDTO);
}
