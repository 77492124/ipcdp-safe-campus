package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.AppVersionControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveAppVersionRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:06
 * @Version 1.0
 */
@Component
public class AppVersionControllerApiFallBack implements AppVersionControllerApi {
    @Override
    public QueryResponseResult<FindAppVersionListResponseDTO> findAppVersionList(FindAppVersionListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveAppVersion(SaveAppVersionRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
