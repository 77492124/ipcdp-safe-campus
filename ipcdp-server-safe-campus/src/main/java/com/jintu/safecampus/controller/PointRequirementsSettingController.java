package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.PointRequirementsSettingControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditPointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IPointRequirementsSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 点位需求设置 点位需求设置表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "选点及人员配置接口")
@RestController
@RequestMapping("/point-requirements-setting")
public class PointRequirementsSettingController implements PointRequirementsSettingControllerApi {

    @Resource
    private IPointRequirementsSettingService pointRequirementsSettingService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据护学岗时间id查询人员配置列表")
    @ApiOperation(value = "根据护学岗时间id查询人员配置列表", response = FindPointSettingListResponseDTO.class)
    @Override
    public QueryResponseResult<FindPointSettingListResponseDTO> findPointRequirementsSettingList(Long nursingPostTimeId) {
        return pointRequirementsSettingService.findPointRequirementsSettingList(nursingPostTimeId);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加时间点位人员配置")
    @ApiOperation(value = "添加时间点位人员配置", response = ResponseResult.class)
    @Override
    public ResponseResult savePointRequirementsSetting(SavePointRequirementsSettingRequestDTO requestDTO) {
        return pointRequirementsSettingService.savePointRequirementsSetting(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑时间点位人员配置")
    @ApiOperation(value = "编辑时间点位人员配置", response = ResponseResult.class)
    @Override
    public ResponseResult editPointRequirementsSetting(EditPointRequirementsSettingRequestDTO requestDTO) {
        return pointRequirementsSettingService.editPointRequirementsSetting(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据id删除时间点位人员配置")
    @ApiOperation(value = "根据id删除时间点位人员配置", response = ResponseResult.class)
    @Override
    public ResponseResult delPointRequirementsSetting(Long id) {
        return pointRequirementsSettingService.delPointRequirementsSetting(id);
    }
}
