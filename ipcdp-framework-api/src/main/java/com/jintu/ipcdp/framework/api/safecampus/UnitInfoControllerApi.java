package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.FindUnitInfoListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Parker
 * @Description: 单位信息接口
 * @Date 2020/1/6 17:31
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/unit-info/", fallback = UnitInfoControllerApiFallBack.class)
public interface UnitInfoControllerApi {
    /**
     * 查询单位信息列表
     * @param requestDTO 查询信息
     * @return 列表
     */
    @GetMapping("list")
    QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(@Validated FindUnitInfoListRequestDTO requestDTO);
}
