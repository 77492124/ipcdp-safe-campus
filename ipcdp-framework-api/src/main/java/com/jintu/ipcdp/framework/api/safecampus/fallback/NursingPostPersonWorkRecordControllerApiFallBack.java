package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.NursingPostPersonWorkRecordControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonUnWorkRecordRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonUnWorkRecordResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Description
 * @Date 2020/1/17 9:28
 * @Created by lyx
 */
@Component
public class NursingPostPersonWorkRecordControllerApiFallBack implements NursingPostPersonWorkRecordControllerApi {
    @Override
    public ResponseResult nursingPostWork(NursingPostWorkRequestDTO nursingPostWorkRequestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public QueryResponseResult<NursingPostPersonUnWorkRecordResponseDTO> findNursingPostPersonUnWorkRecord(NursingPostPersonUnWorkRecordRequestDTO nursingPostPersonUnWorkRecordRequestDTO) {
        return QueryResponseResult.SERVER_ANOMALY();
    }
}
