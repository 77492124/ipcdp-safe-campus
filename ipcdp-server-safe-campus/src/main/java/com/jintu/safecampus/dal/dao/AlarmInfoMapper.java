package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import com.jintu.safecampus.dal.model.AlarmInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 告警表 告警信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface AlarmInfoMapper extends BaseMapper<AlarmInfo> {
    /**
     * 查询告警列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return 告警列表
     */
    IPage<FindAlarmInfoListResponseDTO> findAlarmInfoList(Page<FindAlarmInfoListResponseDTO> page, @Param("dto") FindAlarmInfoListRequestDTO requestDTO);
}
