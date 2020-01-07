package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import com.jintu.safecampus.dal.model.SysLogging;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统日志表 系统操作日志表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface SysLoggingMapper extends BaseMapper<SysLogging> {
    /**
     * 查询系统日志列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return 日志列表
     */
    IPage<FindSysLoggingListResponseDTO> findSysLoggingList(Page<FindSysLoggingListResponseDTO> page, @Param("dto") FindSysLoggingListRequestDTO requestDTO);
}
