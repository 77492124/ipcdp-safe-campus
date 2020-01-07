package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.SysLoggingControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Parker
 * @Description: 系统日志API
 * @Date 2020/1/7 16:45
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/sys-logging/", fallback = SysLoggingControllerApiFallBack.class)
public interface SysLoggingControllerApi {

    /**
     * 查询系统日志列表
     * @param requestDTO 查询条件
     * @return 日志列表
     */
    @GetMapping("list")
    QueryResponseResult<FindSysLoggingListResponseDTO> findSysLoggingList(@Validated FindSysLoggingListRequestDTO requestDTO);
}
