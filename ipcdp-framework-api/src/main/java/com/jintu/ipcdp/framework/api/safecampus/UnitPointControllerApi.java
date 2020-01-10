package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitPointControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 单位点位API
 * @Date 2020/1/10 11:33
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/unit-point/", fallback = UnitPointControllerApiFallBack.class)
public interface UnitPointControllerApi {

    /**
     * 查询单位点位列表
     * @param requestDTO 查询条件
     * @return 点位列表
     */
    @GetMapping("list")
    QueryResponseResult<FindUnitPointListResponseDTO> findUnitPointList(@Validated FindUnitPointListRequestDTO requestDTO);

    /**
     * 添加单位点位
     * @param requestDTO 单位点位
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveUnitPoint(@Validated @RequestBody SaveUnitPointRequestDTO requestDTO);

    /**
     * 编辑单位点位
     * @param requestDTO 单位点位
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editUnitPoint(@Validated @RequestBody EditUnitPointRequestDTO requestDTO);

    /**
     * 删除单位点位
     * @param unitPointId 单位点位Id
     * @return 是否成功
     */
    @DeleteMapping("{unitPointId}")
    ResponseResult delUnitPoint(@PathVariable("unitPointId") Long unitPointId);
}
