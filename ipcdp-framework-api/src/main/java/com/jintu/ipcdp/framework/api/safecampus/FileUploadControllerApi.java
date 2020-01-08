package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.FileUploadControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.GetUploadTokenResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Parker
 * @Description: 文件上传API
 * @Date 2020/1/8 10:04
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/file-upload/", fallback = FileUploadControllerApiFallBack.class)
public interface FileUploadControllerApi {

    /**
     * 获取上传Token
     * @param suffix 文件后缀（扩展名，例：jpg）
     * @return  Token
     */
    @GetMapping("getUpToken/{suffix}")
    CommonResponseResult<GetUploadTokenResponseDTO> getUploadToken(@PathVariable("suffix") String suffix);
}
