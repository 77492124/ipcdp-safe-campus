package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.JobInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindJobInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.JobAuthorizeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobResourcesIdsResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IJobInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 岗位信息表 岗位信息表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "岗位信息接口")
@RestController
@RequestMapping("/job-info")
public class JobInfoController implements JobInfoControllerApi {

    @Resource
    private IJobInfoService jobInfoService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位的岗位列表")
    @ApiOperation(value = "查询单位的岗位列表", response = FindJobInfoListResponseDTO.class)
    @Override
    public QueryResponseResult<FindJobInfoListResponseDTO> findJobInfoList(FindJobInfoListRequestDTO requestDTO) {
        return jobInfoService.findJobInfoList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "根据岗位id查询岗位")
    @ApiOperation(value = "根据岗位id查询岗位", response = FindJobInfoByIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindJobInfoByIdResponseDTO> findJobInfoById(Long jobInfoId) {
        return jobInfoService.findJobInfoById(jobInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加岗位")
    @ApiOperation(value = "添加岗位", response = ResponseResult.class)
    @Override
    public ResponseResult saveJobInfo(SaveJobInfoRequestDTO requestDTO) {
        return jobInfoService.saveJobInfo(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑岗位")
    @ApiOperation(value = "编辑岗位", response = ResponseResult.class)
    @Override
    public ResponseResult editJobInfo(EditJobInfoRequestDTO requestDTO) {
        return jobInfoService.editJobInfo(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据岗位id删除岗位")
    @ApiOperation(value = "根据岗位id删除岗位", response = ResponseResult.class)
    @Override
    public ResponseResult delJobInfo(Long jobInfoId) {
        return jobInfoService.delJobInfo(jobInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "岗位id查询资源权限id列表(授权)")
    @ApiOperation(value = "岗位id查询资源权限id列表(授权)", response = FindJobResourcesIdsResponseDTO.class)
    @Override
    public QueryResponseResult<FindJobResourcesIdsResponseDTO> findJobResourcesIds(Long jobInfoId) {
        return jobInfoService.findJobResourcesIds(jobInfoId);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "岗位授权")
    @ApiOperation(value = "岗位授权", response = ResponseResult.class)
    @Override
    public ResponseResult jobAuthorize(JobAuthorizeRequestDTO requestDTO) {
        return jobInfoService.jobAuthorize(requestDTO);
    }
}
