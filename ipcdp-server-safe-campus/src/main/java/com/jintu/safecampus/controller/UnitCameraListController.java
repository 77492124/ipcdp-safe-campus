package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitCameraListControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitCameraRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitCameraRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IUnitCameraListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 单位摄像头列表 单位摄像头列表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "单位摄像头接口")
@RestController
@RequestMapping("/unit-camera-list")
public class UnitCameraListController implements UnitCameraListControllerApi {

    @Resource
    private IUnitCameraListService unitCameraListService;

    @MyLog(actionType = ActionTypeEnum.FIND,description = "查询单位摄像头列表")
    @ApiOperation(value = "查询单位摄像头列表", response = FindUnitPointListResponseDTO.class)
    @Override
    public QueryResponseResult<FindUnitCameraListResponseDTO> findUnitCameraList(FindUnitPointListRequestDTO requestDTO) {
        return unitCameraListService.findUnitCameraList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE,description = "添加单位摄像头")
    @ApiOperation(value = "添加单位摄像头", response = ResponseResult.class)
    @Override
    public ResponseResult saveUnitCamera(SaveUnitCameraRequestDTO requestDTO) {
        return unitCameraListService.saveUnitPoint(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE,description = "修改单位摄像头")
    @ApiOperation(value = "修改单位摄像头", response = ResponseResult.class)
    @Override
    public ResponseResult editUnitCamera(EditUnitCameraRequestDTO requestDTO) {
        return unitCameraListService.editUnitCamera(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE,description = "删除单位摄像头")
    @ApiOperation(value = "删除单位摄像头", response = ResponseResult.class)
    @Override
    public ResponseResult delUnitCamera(Long unitCameraId) {
        return unitCameraListService.delUnitCamera(unitCameraId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND,description = "查询单位摄像头")
    @ApiOperation(value = "查询单位摄像头", response = FindUnitCameraListResponseDTO.class)
    @Override
    public CommonResponseResult<FindUnitCameraListResponseDTO> findUnitCamera(Long unitCameraListID) {
        return unitCameraListService.findUnitCamera(unitCameraListID);
    }
}
