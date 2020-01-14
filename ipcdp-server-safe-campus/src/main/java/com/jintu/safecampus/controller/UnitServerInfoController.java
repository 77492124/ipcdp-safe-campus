package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitServerInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitServerInfoListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IUnitServerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 单位服务器列表 单位服务器列表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "单位服务器列表接口")
@RestController
@RequestMapping("/unit-server-info")
public class UnitServerInfoController implements UnitServerInfoControllerApi {

    @Resource
    private IUnitServerInfoService unitServerInfoService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位服务器列表")
    @ApiOperation(value = "查询单位服务器列表", response = FindUnitServerInfoListResponseDTO.class)
    @Override
    public QueryResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfoList(FindUnitPointListRequestDTO requestDTO) {
        return unitServerInfoService.findUnitServerInfoList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "增加单位服务器")
    @ApiOperation(value = "增加单位服务器", response = ResponseResult.class)
    @Override
    public ResponseResult saveUnitServerInfo(SaveUnitServerInfoRequestDTO requestDTO) {
        return unitServerInfoService.saveUnitServerInfoList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "修改单位服务器")
    @ApiOperation(value = "修改单位服务器", response = ResponseResult.class)
    @Override
    public ResponseResult editUnitServerInfo(EditUnitServerInfoRequestDTO requestDTO) {
        return unitServerInfoService.editUnitServerInfo(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "删除单位服务器")
    @ApiOperation(value = "删除单位服务器", response = ResponseResult.class)
    @Override
    public ResponseResult delUnitServerInfo(Long unitServerInfoId) {
        return unitServerInfoService.delUnitServerInfo(unitServerInfoId);
    }
}
