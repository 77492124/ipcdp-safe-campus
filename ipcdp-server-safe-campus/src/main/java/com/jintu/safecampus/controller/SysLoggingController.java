package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.SysLoggingControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.ISysLoggingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统日志表 系统操作日志表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "系统日志接口")
@RestController
@RequestMapping("/sys-logging")
public class SysLoggingController implements SysLoggingControllerApi {

    @Resource
    private ISysLoggingService sysLoggingService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询系统日志列表")
    @ApiOperation(value = "查询系统日志列表", response = FindSysLoggingListResponseDTO.class)
    @Override
    public QueryResponseResult<FindSysLoggingListResponseDTO> findSysLoggingList(FindSysLoggingListRequestDTO requestDTO) {
        return sysLoggingService.findSysLoggingList(requestDTO);
    }
}
