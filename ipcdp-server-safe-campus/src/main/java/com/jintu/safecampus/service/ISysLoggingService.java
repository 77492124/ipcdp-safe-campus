package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import com.jintu.safecampus.dal.model.SysLogging;

/**
 * <p>
 * 系统日志表 系统操作日志表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface ISysLoggingService extends IService<SysLogging> {
    /**
     * 查询系统日志列表
     * @param requestDTO 查询条件
     * @return 日志列表
     */
    QueryResponseResult<FindSysLoggingListResponseDTO> findSysLoggingList(FindSysLoggingListRequestDTO requestDTO);
}
