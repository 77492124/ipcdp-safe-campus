package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.EmployeeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
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
}
