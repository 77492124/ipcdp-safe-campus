package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitServerInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitServerInfoListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Parker
 * @Description: 单位服务器列表API
 * @Date 2020/1/7 11:43
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/unit-server-info/", fallback = UnitServerInfoControllerApiFallBack.class)
public interface UnitServerInfoControllerApi {

    /**
     * 查询单位服务器列表
     * @param requestDTO 查询条件
     * @return 点位列表
     */
    @GetMapping("findUnitServerInfoList")
    QueryResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfoList(@Validated FindUnitPointListRequestDTO requestDTO);

    /**
     * 添加单位服务器
     * @param requestDTO
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveUnitServerInfo(@Validated @RequestBody SaveUnitServerInfoRequestDTO requestDTO);

    /**
     * 修改单位服务器
     * @param requestDTO
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editUnitServerInfo(@Validated @RequestBody EditUnitServerInfoRequestDTO requestDTO);

    /**
     * 删除单位服务器
     * @param unitSserverInfoId 单位点位Id
     * @return 是否成功
     */
    @DeleteMapping("{unitSserverInfoId}")
    ResponseResult delUnitServerInfo(@PathVariable("unitSserverInfoId") Long unitSserverInfoId);

}
