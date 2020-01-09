package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.EmployeeDataRangeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindDataRangeByEmployeeIdResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IEmployeeDataRangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 员工数据范围 员工数据范围 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "员工数据范围接口")
@RestController
@RequestMapping("/employee-data-range")
public class EmployeeDataRangeController implements EmployeeDataRangeControllerApi {

    @Resource
    private IEmployeeDataRangeService employeeDataRangeService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据员工id查询数据范围")
    @ApiOperation(value = "根据员工id查询数据范围", response = FindDataRangeByEmployeeIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindDataRangeByEmployeeIdResponseDTO> findDataRangeByEmployeeId(Long employeeId) {
        return employeeDataRangeService.findDataRangeByEmployeeId(employeeId);
    }
}
