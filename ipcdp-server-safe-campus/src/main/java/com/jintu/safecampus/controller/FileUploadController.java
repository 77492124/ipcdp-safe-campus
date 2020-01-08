package com.jintu.safecampus.controller;

import com.jintu.ipcdp.framework.api.safecampus.FileUploadControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.GetUploadTokenResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.common.util.QiNiuUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Parker
 * @Description: 文件上传API
 * @Date 2020/1/8 9:41
 * @Version 1.0
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/file-upload")
public class FileUploadController implements FileUploadControllerApi {

    @Resource
    private QiNiuUtils qiNiuUtils;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "获取上传Token")
    @ApiOperation(value = "获取上传Token", response = GetUploadTokenResponseDTO.class)
    @Override
    public CommonResponseResult<GetUploadTokenResponseDTO> getUploadToken(String suffix) {
        GetUploadTokenResponseDTO responseDTO = new GetUploadTokenResponseDTO();
        responseDTO.setFileName(qiNiuUtils.getFileName(suffix));
        responseDTO.setToken(qiNiuUtils.getUpToken());
        return new CommonResponseResult<>(responseDTO);
    }
}
