package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.SysServerInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditSysServerRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveSysServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditSysServerResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
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
 * @Description: 系统服务器API
 * @Date 2020/1/7 11:48
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/sys-server-info/", fallback = SysServerInfoControllerApiFallBack.class)
public interface SysServerInfoControllerApi {

    /**
     * 查询服务器列表
     * @param requestDTO 查询条件
     * @return 服务器列表信息
     */
    @GetMapping("list")
    QueryResponseResult<FindSysServerListResponseDTO> findSysServerList(@Validated FindSysServerListRequestDTO requestDTO);

    /**
     * 根据服务器id查询服务器信息
     * @param sysServerInfoId 服务器id
     * @return  服务器信息
     */
    @GetMapping("{sysServerInfoId}")
    CommonResponseResult<FindSysServerByIdResponseDTO> findSysServerById(@PathVariable("sysServerInfoId") Long sysServerInfoId);

    /**
     * 添加系统服务器
     * @param requestDTO 系统服务器
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveSysServer(@Validated @RequestBody SaveSysServerInfoRequestDTO requestDTO);

    /**
     * 编辑系统服务器
     * @param requestDTO 系统服务器
     * @return 编辑后信息
     */
    @PutMapping
    CommonResponseResult<EditSysServerResponseDTO> editSysServer(@Validated @RequestBody EditSysServerRequestDTO requestDTO);

    /**
     * 根据系统服务器id删除
     * @param sysServerInfoId 系统服务器id
     * @return 是否成功
     */
    @DeleteMapping("{sysServerInfoId}")
    ResponseResult delSysServer(@PathVariable("sysServerInfoId") Long sysServerInfoId);

}
