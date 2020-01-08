package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.JobInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
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
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 11:59
 * @Version 1.0
 */
@Component
public class JobInfoControllerApiFallBack implements JobInfoControllerApi {
    @Override
    public QueryResponseResult<FindJobInfoListResponseDTO> findJobInfoList(FindJobInfoListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public CommonResponseResult<FindJobInfoByIdResponseDTO> findJobInfoById(Long jobInfoId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveJobInfo(SaveJobInfoRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult editJobInfo(EditJobInfoRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delJobInfo(Long jobInfoId) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public QueryResponseResult<FindJobResourcesIdsResponseDTO> findJobResourcesIds(Long jobInfoId) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult jobAuthorize(JobAuthorizeRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
