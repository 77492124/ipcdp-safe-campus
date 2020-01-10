package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.AlarmInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Parker
 * @Description: 告警接口
 * @Date 2020/1/10 11:04
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/alarm-info/", fallback = AlarmInfoControllerApiFallBack.class)
public interface AlarmInfoControllerApi {

    /**
     * 查询告警列表
     * @param requestDTO 查询条件
     * @return 告警列表
     */
    @GetMapping("list")
    QueryResponseResult<FindAlarmInfoListResponseDTO> findAlarmInfoList(@Validated FindAlarmInfoListRequestDTO requestDTO);

    /**
     * 根据id查询告警详情
     * @param alarmInfoId 告警id
     * @return 详情
     */
    @GetMapping("{alarmInfoId}")
    CommonResponseResult<FindAlarmInfoByIdResponseDTO> findAlarmInfoById(@PathVariable("alarmInfoId") Long alarmInfoId);
}
