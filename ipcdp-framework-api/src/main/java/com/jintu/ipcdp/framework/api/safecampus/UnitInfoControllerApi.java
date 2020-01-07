package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
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

    /**
     * 新增单位
     * @param requestDTO 单位信息
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveUnitInfo(@Validated @RequestBody SaveUnitInfoRequestDTO requestDTO);

    /**
     * 编辑单位
     * @param requestDTO 单位信息
     * @return 编辑后的信息
     */
    @PutMapping
    CommonResponseResult<EditUnitInfoResponseDTO> editUnitInfo(@Validated @RequestBody EditUnitInfoRequestDTO requestDTO);

    /**
     * 根据单位id查询单位信息
     * @param unitInfoId 单位id
     * @return 单位信息
     */
    @GetMapping("{unitInfoId}")
    CommonResponseResult<EditUnitInfoResponseDTO> findUnitInfoById(@PathVariable("unitInfoId") Long unitInfoId);

    /**
     * 根据单位id删除单位
     * @param unitInfoId 单位id
     * @return 是否成功
     */
    @DeleteMapping("{unitInfoId}")
    ResponseResult delUnitInfo(@PathVariable("unitInfoId") Long unitInfoId);
}
