package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.AppVersionControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveAppVersionRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IAppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * app版本发布 app版本发布表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "app版本发布接口")
@RestController
@RequestMapping("/app-version")
public class AppVersionController implements AppVersionControllerApi {

    @Resource
    private IAppVersionService appVersionService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询App版本发布列表")
    @ApiOperation(value = "查询App版本发布列表", response = FindAppVersionListResponseDTO.class)
    @Override
    public QueryResponseResult<FindAppVersionListResponseDTO> findAppVersionList(FindAppVersionListRequestDTO requestDTO) {
        return appVersionService.findAppVersionList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "App版本发布")
    @ApiOperation(value = "App版本发布", response = ResponseResult.class)
    @Override
    public ResponseResult saveAppVersion(SaveAppVersionRequestDTO requestDTO) {
        return appVersionService.saveAppVersion(requestDTO);
    }
}
