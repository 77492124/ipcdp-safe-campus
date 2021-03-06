package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitServerInfoListResponseDTO;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.dao.UnitServerInfoMapper;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.dal.model.UnitPoint;
import com.jintu.safecampus.dal.model.UnitServerInfo;
import com.jintu.safecampus.service.IUnitServerInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 单位服务器列表 单位服务器列表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class UnitServerInfoServiceImpl extends ServiceImpl<UnitServerInfoMapper, UnitServerInfo> implements IUnitServerInfoService {

    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public QueryResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfoList(FindUnitPointListRequestDTO requestDTO) {
        UnitInfo unitInfo = unitInfoMapper.selectById(requestDTO.getUnitInfoId());
        if(ObjectUtils.isEmpty(unitInfo)){
            ExceptionCast.cast("找不到单位信息");
        }

        Page<FindUnitServerInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("u.created_time"));
        IPage<FindUnitServerInfoListResponseDTO> iPage = baseMapper.findUnitServerInfoList(page,requestDTO);
        QueryResult<FindUnitServerInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveUnitServerInfoList(SaveUnitServerInfoRequestDTO requestDTO) {
        UnitInfo unitInfo = unitInfoMapper.selectById(requestDTO.getUnitInfoId());
        if(ObjectUtils.isEmpty(unitInfo)){
            ExceptionCast.cast("找不到单位信息");
        }

        UnitServerInfo unitServerInfo = new UnitServerInfo();
        BeanUtils.copyProperties(requestDTO,unitServerInfo);
        boolean save = this.save(unitServerInfo);
        if(!save){
            ExceptionCast.cast("新增服务器失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editUnitServerInfo(EditUnitServerInfoRequestDTO requestDTO) {
        boolean update = new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(UnitServerInfo::getId, requestDTO.getId())
                .set(UnitServerInfo::getServerName, requestDTO.getServerName())
                .set(UnitServerInfo::getServerType, requestDTO.getServerType())
                .set(UnitServerInfo::getIpAddress, requestDTO.getIpAddress())
                .set(UnitServerInfo::getPortNumber, requestDTO.getPortNumber())
                .update();
        if(!update){
            ExceptionCast.cast("修改服务器失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult delUnitServerInfo(Long unitServerInfoId) {
        int count = this.count(Wrappers.<UnitServerInfo>lambdaQuery().eq(UnitServerInfo::getId, unitServerInfoId));
        if (count<=0) {
            ExceptionCast.cast("该服务器不存在！");
        }
        boolean b = this.removeById(unitServerInfoId);
        if (!b) {
            ExceptionCast.cast("删除失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfo(Long unitServerInfoId) {
        UnitServerInfo unitServerInfo = baseMapper.selectById(unitServerInfoId);
        if(ObjectUtils.isEmpty(unitServerInfo)){
            ExceptionCast.cast("查询不到服务器信息");
        }
        FindUnitServerInfoListResponseDTO responseDTO = new FindUnitServerInfoListResponseDTO();
        BeanUtils.copyProperties(unitServerInfo,responseDTO);
        return new CommonResponseResult(responseDTO);
    }
}
