package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.SysServerInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditSysServerRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveSysServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditSysServerResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.ISysServerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 系统服务器信息表 系统服务器信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "系统服务器接口")
@RestController
@RequestMapping("/sys-server-info")
public class SysServerInfoController implements SysServerInfoControllerApi {

    @Resource
    private ISysServerInfoService sysServerInfoService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询系统服务器列表")
    @ApiOperation(value = "查询系统服务器列表", response = FindSysServerListResponseDTO.class)
    @Override
    public QueryResponseResult<FindSysServerListResponseDTO> findSysServerList(FindSysServerListRequestDTO requestDTO) {
        return sysServerInfoService.findSysServerList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据系统服务器id查询服务器信息")
    @ApiOperation(value = "根据服务器id查询服务器信息", response = FindSysServerByIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindSysServerByIdResponseDTO> findSysServerById(Long sysServerInfoId) {
        return sysServerInfoService.findSysServerById(sysServerInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加系统服务器")
    @ApiOperation(value = "添加系统服务器", response = ResponseResult.class)
    @Override
    public ResponseResult saveSysServer(SaveSysServerInfoRequestDTO requestDTO) {
        return sysServerInfoService.saveSysServer(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑系统服务器")
    @ApiOperation(value = "编辑系统服务器", response = EditSysServerResponseDTO.class)
    @Override
    public CommonResponseResult<EditSysServerResponseDTO> editSysServer(EditSysServerRequestDTO requestDTO) {
        return sysServerInfoService.editSysServer(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据系统服务器id删除")
    @ApiOperation(value = "根据系统服务器id删除", response = ResponseResult.class)
    @Override
    public ResponseResult delSysServer(Long sysServerInfoId) {
        return sysServerInfoService.delSysServer(sysServerInfoId);
    }
}
