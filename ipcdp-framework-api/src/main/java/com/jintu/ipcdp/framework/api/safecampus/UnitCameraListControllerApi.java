package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.SysServerInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitCameraListControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname
 * @Description 单位摄像头列表Api
 * @Date 2020/1/14 9:01
 * @Created by lyx
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/unit-camera-list/", fallback = UnitCameraListControllerApiFallBack.class)
public interface UnitCameraListControllerApi {
    /**
     * 查询单位摄像头列表
     * @param requestDTO 查询条件
     * @return 点位列表
     */
    @GetMapping("list")
    QueryResponseResult<FindUnitCameraListResponseDTO> findUnitCameraList(@Validated FindUnitPointListRequestDTO requestDTO);

//    /**
//     * 添加单位摄像头
//     * @param requestDTO 单位点位
//     * @return 是否成功
//     */
//    @PostMapping
//    ResponseResult saveUnitPoint(@Validated @RequestBody SaveUnitPointRequestDTO requestDTO);
//
//    /**
//     * 编辑单位摄像头
//     * @param requestDTO 单位点位
//     * @return 是否成功
//     */
//    @PutMapping
//    ResponseResult editUnitPoint(@Validated @RequestBody EditUnitPointRequestDTO requestDTO);
//
//    /**
//     * 删除单位摄像头
//     * @param unitPointId 单位点位Id
//     * @return 是否成功
//     */
//    @DeleteMapping("{unitPointId}")
//    ResponseResult delUnitPoint(@PathVariable("unitPointId") Long unitPointId);
}
