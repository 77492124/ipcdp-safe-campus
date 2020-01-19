package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IUnitInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 单位信息表 单位信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "单位信息接口 ")
@RestController
@RequestMapping("/unit-info")
public class UnitInfoController implements UnitInfoControllerApi {

    @Resource
    private IUnitInfoService unitInfoService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位列表")
    @ApiOperation(value = "查询单位列表", response = FindUnitInfoListResponseDTO.class)
    @Override
    public QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO) {
        return unitInfoService.findUnitInfoList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "新增单位")
    @ApiOperation(value = "新增单位", response = ResponseResult.class)
    @Override
    public ResponseResult saveUnitInfo(SaveUnitInfoRequestDTO requestDTO) {
        return unitInfoService.saveUnitInfo(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑单位")
    @ApiOperation(value = "编辑单位", response = EditUnitInfoResponseDTO.class)
    @Override
    public CommonResponseResult<EditUnitInfoResponseDTO> editUnitInfo(EditUnitInfoRequestDTO requestDTO) {
        return unitInfoService.editUnitInfo(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据单位id查询单位信息")
    @ApiOperation(value = "根据单位id查询单位信息", response = EditUnitInfoResponseDTO.class)
    @Override
    public CommonResponseResult<EditUnitInfoResponseDTO> findUnitInfoById(Long unitInfoId) {
        return unitInfoService.findUnitInfoById(unitInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据单位id删除单位")
    @ApiOperation(value = "根据单位id删除单位", response = ResponseResult.class)
    @Override
    public ResponseResult delUnitInfo(Long unitInfoId) {
        return unitInfoService.delUnitInfo(unitInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询学校列表")
    @ApiOperation(value = "查询学校列表", response = FindSchoolListResponseDTO.class)
    @Override
    public QueryResponseResult<FindSchoolListResponseDTO> findSchoolList(String unitName) {
        return unitInfoService.findSchoolList(unitName);
    }
}
