package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.NursingPostTimeControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 16:46
 * @Version 1.0
 */
@Component
public class NursingPostTimeControllerApiFallBack implements NursingPostTimeControllerApi {
    @Override
    public QueryResponseResult<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(FindNursingPostTimeListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveNursingPostTime(SaveNursingPostTimeRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult editNursingPostTime(EditNursingPostTimeRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delNursingPostTime(Long nursingPostTimeId) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
