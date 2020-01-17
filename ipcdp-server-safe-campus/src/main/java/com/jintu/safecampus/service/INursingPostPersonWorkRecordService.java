package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonUnWorkRecordRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonUnWorkRecordResponseDTO;
import com.jintu.safecampus.dal.model.NursingPostPersonWorkRecord;

/**
 * <p>
 * 护学岗人员上班记录  服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
public interface INursingPostPersonWorkRecordService extends IService<NursingPostPersonWorkRecord> {
    /**
     * 护学岗人员上下班
     * @param requestDTO
     * @return
     */
    ResponseResult nursingPostWork(NursingPostWorkRequestDTO requestDTO);

    /**
     * 查询脱岗记录
     * @param requestDTO
     * @return
     */
    QueryResponseResult<NursingPostPersonUnWorkRecordResponseDTO> findNursingPostPersonUnWorkRecord(NursingPostPersonUnWorkRecordRequestDTO requestDTO);
}
