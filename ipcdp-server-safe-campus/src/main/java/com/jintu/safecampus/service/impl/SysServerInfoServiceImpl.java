package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditSysServerRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysServerListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveSysServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditSysServerResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysServerListResponseDTO;
import com.jintu.safecampus.dal.dao.SysServerInfoMapper;
import com.jintu.safecampus.dal.model.SysServerInfo;
import com.jintu.safecampus.service.ISysServerInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统服务器信息表 系统服务器信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class SysServerInfoServiceImpl extends ServiceImpl<SysServerInfoMapper, SysServerInfo> implements ISysServerInfoService {

    @Override
    public QueryResponseResult<FindSysServerListResponseDTO> findSysServerList(FindSysServerListRequestDTO requestDTO) {
        Page<FindSysServerListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindSysServerListResponseDTO> iPage = baseMapper.findSysServerList(page,requestDTO);
        QueryResult<FindSysServerListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public CommonResponseResult<FindSysServerByIdResponseDTO> findSysServerById(Long sysServerInfoId) {
        FindSysServerByIdResponseDTO responseDTO = baseMapper.findSysServerById(sysServerInfoId);
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public ResponseResult saveSysServer(SaveSysServerInfoRequestDTO requestDTO) {
        int serverNameCount = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getServerName, requestDTO.getServerName()));
        if (serverNameCount > 0) {
            ExceptionCast.cast("服务器名称不能重复！");
        }
        int ipCount = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getIpAddress, requestDTO.getIpAddress()));
        if (ipCount > 0) {
            ExceptionCast.cast("服务器IP不能重复！");
        }
        SysServerInfo sysServerInfo = new SysServerInfo();
        BeanUtils.copyProperties(requestDTO,sysServerInfo);
        this.save(sysServerInfo);
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<EditSysServerResponseDTO> editSysServer(EditSysServerRequestDTO requestDTO) {
        int count = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getId, requestDTO.getId()));
        if (count <= 0) {
            ExceptionCast.cast("编辑的服务器不存在！");
        }
        if (StringUtils.isNotBlank(requestDTO.getServerName())) {
            int nameCount = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getServerName, requestDTO.getServerName()).ne(SysServerInfo::getId, requestDTO.getId()));
            if (nameCount > 0) {
                ExceptionCast.cast("服务器名称不能重复！");
            }
        }
        if (StringUtils.isNotBlank(requestDTO.getIpAddress())) {
            int ipCount = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getIpAddress, requestDTO.getIpAddress()).ne(SysServerInfo::getId, requestDTO.getId()));
            if (ipCount > 0) {
                ExceptionCast.cast("服务器IP不能重复！");
            }
        }
        SysServerInfo update = new SysServerInfo();
        BeanUtils.copyProperties(requestDTO,update);
        this.updateById(update);
        EditSysServerResponseDTO responseDTO = new EditSysServerResponseDTO().setId(update.getId()).setServerName(update.getServerName())
                .setServerType(update.getServerType()).setIpAddress(update.getIpAddress()).setPortNumber(update.getPortNumber());
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public ResponseResult delSysServer(Long sysServerInfoId) {
        int count = this.count(Wrappers.<SysServerInfo>lambdaQuery().eq(SysServerInfo::getId, sysServerInfoId));
        if (count <= 0) {
            ExceptionCast.cast("删除的服务器不存在！");
        }
        this.removeById(sysServerInfoId);
        return ResponseResult.SUCCESS();
    }
}
