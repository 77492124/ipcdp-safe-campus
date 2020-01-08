package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.FileUploadControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.GetUploadTokenResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 10:05
 * @Version 1.0
 */
@Component
public class FileUploadControllerApiFallBack implements FileUploadControllerApi {
    @Override
    public CommonResponseResult<GetUploadTokenResponseDTO> getUploadToken(String suffix) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
