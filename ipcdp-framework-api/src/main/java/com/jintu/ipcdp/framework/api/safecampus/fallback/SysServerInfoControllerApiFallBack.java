package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.SysServerInfoControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditSysServerRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveSysServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditSysServerResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 11:48
 * @Version 1.0
 */
@Component
public class SysServerInfoControllerApiFallBack implements SysServerInfoControllerApi {
    @Override
    public QueryResponseResult<FindSysServerListResponseDTO> findSysServerList(FindSysServerListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public CommonResponseResult<FindSysServerByIdResponseDTO> findSysServerById(Long sysServerInfoId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveSysServer(SaveSysServerInfoRequestDTO requestDTO) {
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<EditSysServerResponseDTO> editSysServer(EditSysServerRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult delSysServer(Long sysServerInfoId) {
        return ResponseResult.SUCCESS();
    }
}
