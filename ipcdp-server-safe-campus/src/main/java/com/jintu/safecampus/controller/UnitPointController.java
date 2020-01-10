package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitPointControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IUnitPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 单位点位 单位点位信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "单位点位接口 ")
@RestController
@RequestMapping("/unit-point")
public class UnitPointController implements UnitPointControllerApi {

    @Resource
    private IUnitPointService unitPointService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位点位列表")
    @ApiOperation(value = "查询单位点位列表", response = FindUnitPointListResponseDTO.class)
    @Override
    public QueryResponseResult<FindUnitPointListResponseDTO> findUnitPointList(FindUnitPointListRequestDTO requestDTO) {
        return unitPointService.findUnitPointList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加单位点位")
    @ApiOperation(value = "添加单位点位", response = ResponseResult.class)
    @Override
    public ResponseResult saveUnitPoint(SaveUnitPointRequestDTO requestDTO) {
        return unitPointService.saveUnitPoint(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑单位点位")
    @ApiOperation(value = "编辑单位点位", response = ResponseResult.class)
    @Override
    public ResponseResult editUnitPoint(EditUnitPointRequestDTO requestDTO) {
        return unitPointService.editUnitPoint(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "删除单位点位")
    @ApiOperation(value = "删除单位点位", response = ResponseResult.class)
    @Override
    public ResponseResult delUnitPoint(Long unitPointId) {
        return unitPointService.delUnitPoint(unitPointId);
    }
}
