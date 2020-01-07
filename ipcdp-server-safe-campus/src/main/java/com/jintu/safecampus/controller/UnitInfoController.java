package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.FindUnitInfoListResponseDTO;
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
}
