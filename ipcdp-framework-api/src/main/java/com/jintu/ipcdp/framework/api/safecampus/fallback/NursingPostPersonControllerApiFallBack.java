package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.NursingPostPersonControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 15:25
 * @Version 1.0
 */
@Component
public class NursingPostPersonControllerApiFallBack implements NursingPostPersonControllerApi {
    @Override
    public QueryResponseResult<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(FindNursingPostPersonListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public ResponseResult saveNursingPostPerson(SaveNursingPostPersonRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult editNursingPostPerson(EditNursingPostPersonRequestDTO requestDTO) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public ResponseResult delNursingPostPerson(Long nursingPostPersonId) {
        return ResponseResult.SERVER_ANOMALY();
    }
}
