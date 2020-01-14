package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitCameraListControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IUnitCameraListService;
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
}
