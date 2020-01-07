package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditSysServerRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveSysServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditSysServerResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.safecampus.dal.model.SysServerInfo;

/**
 * <p>
 * 系统服务器信息表 系统服务器信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface ISysServerInfoService extends IService<SysServerInfo> {
    /**
     * 查询服务器列表
     * @param requestDTO 查询条件
     * @return 服务器列表信息
     */
    QueryResponseResult<FindSysServerListResponseDTO> findSysServerList(FindSysServerListRequestDTO requestDTO);
    /**
     * 根据服务器id查询服务器信息
     * @param sysServerInfoId 服务器id
     * @return  服务器信息
     */
    CommonResponseResult<FindSysServerByIdResponseDTO> findSysServerById(Long sysServerInfoId);
    /**
     * 添加系统服务器
     * @param requestDTO 系统服务器
     * @return 是否成功
     */
    ResponseResult saveSysServer(SaveSysServerInfoRequestDTO requestDTO);
    /**
     * 编辑系统服务器
     * @param requestDTO 系统服务器
     * @return 编辑后信息
     */
    CommonResponseResult<EditSysServerResponseDTO> editSysServer(EditSysServerRequestDTO requestDTO);
    /**
     * 根据系统服务器id删除
     * @param sysServerInfoId 系统服务器id
     * @return 是否成功
     */
    ResponseResult delSysServer(Long sysServerInfoId);
}
