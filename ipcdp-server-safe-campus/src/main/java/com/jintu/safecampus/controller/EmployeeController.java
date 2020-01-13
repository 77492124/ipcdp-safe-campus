package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.EmployeeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.*;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 员工表 员工信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "员工信息接口")
@RestController
@RequestMapping("/employee")
public class EmployeeController implements EmployeeControllerApi {

    @Resource
    private IEmployeeService employeeService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "学校员工登录")
    @ApiOperation(value = "学校员工登录", response = EmployeeLoginResponseDTO.class)
    @Override
    public CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(EmployeeLoginRequestDTO requestDTO) {
        return employeeService.employeeLogin(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询学校员工列表")
    @ApiOperation(value = "查询学校员工列表", response = FindEmployeeListResponseDTO.class)
    @Override
    public QueryResponseResult<FindEmployeeListResponseDTO> findEmployeeList(FindEmployeeListRequestDTO requestDTO) {
        return employeeService.findEmployeeList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "新增学校员工")
    @ApiOperation(value = "新增学校员工", response = ResponseResult.class)
    @Override
    public ResponseResult saveEmployee(SaveEmployeeRequestDTO requestDTO) {
        return employeeService.saveEmployee(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据id查询学校员工详情")
    @ApiOperation(value = "根据id查询学校员工详情", response = FindEmployeeByIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindEmployeeByIdResponseDTO> findEmployeeById(Long employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑学校员工")
    @ApiOperation(value = "编辑学校员工", response = ResponseResult.class)
    @Override
    public ResponseResult editEmployee(EditEmployeeRequestDTO requestDTO) {
        return employeeService.editEmployee(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "删除学校员工")
    @ApiOperation(value = "删除学校员工", response = ResponseResult.class)
    @Override
    public ResponseResult delEmployee(Long employeeId) {
        return employeeService.delEmployee(employeeId);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "查询学校员工的权限树")
    @ApiOperation(value = "查询学校员工的权限树", response = FindSchoolResourcesListResponseDTO.class)
    @Override
    public CommonResponseResult<FindSchoolResourcesListResponseDTO> findSchoolResourcesByEmployeeId(Long employeeId) {
        return employeeService.findSchoolResourcesByEmployeeId(employeeId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "学校平安办登录")
    @ApiOperation(value = "学校平安办登录", response = SafeEmployeeLoginResponseDTO.class)
    @Override
    public CommonResponseResult<SafeEmployeeLoginResponseDTO> safeEmployeeLogin(EmployeeLoginRequestDTO requestDTO) {
        return employeeService.safeEmployeeLogin(requestDTO);
    }
}
