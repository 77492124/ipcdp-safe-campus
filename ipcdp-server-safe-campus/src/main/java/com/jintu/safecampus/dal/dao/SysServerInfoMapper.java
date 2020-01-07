package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.safecampus.dal.model.SysServerInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统服务器信息表 系统服务器信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface SysServerInfoMapper extends BaseMapper<SysServerInfo> {
    /**
     * 查询服务器列表
     * @param page 分页信息
     * @param requestDTO 查询条件
     * @return  服务器列表
     */
    IPage<FindSysServerListResponseDTO> findSysServerList(Page<FindSysServerListResponseDTO> page,@Param("dto") FindSysServerListRequestDTO requestDTO);

    /**
     * 根据服务器id查询服务器信息
     * @param sysServerInfoId 服务器id
     * @return  服务器信息
     */
    FindSysServerByIdResponseDTO findSysServerById(Long sysServerInfoId);
}
