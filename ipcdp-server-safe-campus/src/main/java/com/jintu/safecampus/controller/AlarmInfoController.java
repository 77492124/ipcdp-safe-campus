package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.AlarmInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IAlarmInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 告警表 告警信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "告警接口")
@RestController
@RequestMapping("/alarm-info")
public class AlarmInfoController implements AlarmInfoControllerApi {

    @Resource
    private IAlarmInfoService alarmInfoService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询告警列表")
    @ApiOperation(value = "查询告警列表", response = FindAlarmInfoListResponseDTO.class)
    @Override
    public QueryResponseResult<FindAlarmInfoListResponseDTO> findAlarmInfoList(FindAlarmInfoListRequestDTO requestDTO) {
        return alarmInfoService.findAlarmInfoList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据id查询告警详情")
    @ApiOperation(value = "根据id查询告警详情", response = FindAlarmInfoByIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindAlarmInfoByIdResponseDTO> findAlarmInfoById(Long alarmInfoId) {
        return alarmInfoService.findAlarmInfoById(alarmInfoId);
    }
}
