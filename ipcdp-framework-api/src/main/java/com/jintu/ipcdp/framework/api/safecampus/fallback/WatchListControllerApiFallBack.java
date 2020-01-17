package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.WatchListControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWorkInRealTimeStaffListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostTaskRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWorkInRealTimeStaffResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostTaskResponseDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 17:16
 * @Version 1.0
 */
@Component
public class WatchListControllerApiFallBack implements WatchListControllerApi {
    @Override
    public QueryResponseResult<FindWatchListResponseDTO> findWatchList(FindWatchListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public void exportWatchList(ExportWatchListRequestDTO requestDTO, HttpServletResponse response) throws Exception{

    }

    @Override
    public ResponseResult editWatchList(EditWatchListRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public CommonResponseResult<FindWatchListByIdResponseDTO> findWatchListById(Long watchListId) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public CommonResponseResult<FindWorkInRealTimeStaffResponseDTO> findWorkInRealTimeStaffList(FindWorkInRealTimeStaffListRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public QueryResponseResult<NursingPostTaskResponseDTO> findNursingPostTask(NursingPostTaskRequestDTO requestDTO) {
        return QueryResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delWatchList(Long watchListId) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
