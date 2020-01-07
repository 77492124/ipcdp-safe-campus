package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.SysAdministratorControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.AdministratorLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.AdministratorLoginResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.ISysAdministratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统管理员表 系统管理员表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "系统管理员接口 ")
@RestController
@RequestMapping("/sys-administrator")
public class SysAdministratorController implements SysAdministratorControllerApi {

    @Resource
    private ISysAdministratorService sysAdministratorService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "超级管理员登录")
    @ApiOperation(value = "超级管理员登录", response = AdministratorLoginResponseDTO.class)
    @Override
    public CommonResponseResult<AdministratorLoginResponseDTO> administratorLogin(AdministratorLoginRequestDTO requestDTO) {
        return sysAdministratorService.administratorLogin(requestDTO);
    }
}
