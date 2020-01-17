package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
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
     * @param nursingPostWorkRequestDTO
     * @return
     */
    ResponseResult nursingPostWork(NursingPostWorkRequestDTO nursingPostWorkRequestDTO);
}
