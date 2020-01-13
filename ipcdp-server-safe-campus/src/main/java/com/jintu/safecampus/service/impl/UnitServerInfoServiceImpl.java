package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitServerInfoListResponseDTO;
import com.jintu.safecampus.dal.dao.UnitServerInfoMapper;
import com.jintu.safecampus.dal.model.UnitPoint;
import com.jintu.safecampus.dal.model.UnitServerInfo;
import com.jintu.safecampus.service.IUnitServerInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

    @Override
    public QueryResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfoList(FindUnitPointListRequestDTO requestDTO) {
        Page<FindUnitServerInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        IPage<FindUnitServerInfoListResponseDTO> iPage = baseMapper.findUnitServerInfoList(page,requestDTO);
        QueryResult<FindUnitServerInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveUnitServerInfoList(SaveUnitServerInfoRequestDTO requestDTO) {
        UnitServerInfo unitServerInfo = new UnitServerInfo();
        BeanUtils.copyProperties(requestDTO,unitServerInfo);
        unitServerInfo.setCreatedTime(LocalDateTime.now());
        unitServerInfo.setUpdatedTime(LocalDateTime.now());
        boolean save = this.save(unitServerInfo);
        if(!save){
            ExceptionCast.cast("新增服务器失败");
        }
        return ResponseResult.SUCCESS();
    }
}
