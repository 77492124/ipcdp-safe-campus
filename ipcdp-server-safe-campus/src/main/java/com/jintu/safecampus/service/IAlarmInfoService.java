package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import com.jintu.safecampus.dal.model.AlarmInfo;

/**
 * <p>
 * 告警表 告警信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IAlarmInfoService extends IService<AlarmInfo> {
    /**
     * 查询告警列表
     * @param requestDTO 查询条件
     * @return 告警列表
     */
    QueryResponseResult<FindAlarmInfoListResponseDTO> findAlarmInfoList(FindAlarmInfoListRequestDTO requestDTO);
    /**
     * 根据id查询告警详情
     * @param alarmInfoId 告警id
     * @return 详情
     */
    CommonResponseResult<FindAlarmInfoByIdResponseDTO> findAlarmInfoById(Long alarmInfoId);
}
