package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.PointRequirementsPersonnelControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingBaseResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IPointRequirementsPersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 点位需求人员 点位需求人员表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "排班设置接口 ")
@RestController
@RequestMapping("/point-requirements-personnel")
public class PointRequirementsPersonnelController implements PointRequirementsPersonnelControllerApi {

    @Resource
    private IPointRequirementsPersonnelService pointRequirementsPersonnelService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据护学岗时间id查询排班列表主页")
    @ApiOperation(value = "根据护学岗时间id查询排班列表主页", response = FindShiftSettingBaseResponseDTO.class)
    @Override
    public CommonResponseResult<FindShiftSettingBaseResponseDTO> findShiftSetting(FindShiftSettingRequestDTO requestDTO) {
        return pointRequirementsPersonnelService.findShiftSetting(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "保存排班设置")
    @ApiOperation(value = "保存排班设置", response = ResponseResult.class)
    @Override
    public ResponseResult saveShiftSetting(SaveShiftSettingBaseRequestDTO requestDTO) {
        return pointRequirementsPersonnelService.saveShiftSetting(requestDTO);
    }


}
