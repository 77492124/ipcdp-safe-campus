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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAlarmInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAlarmInfoListResponseDTO;
import com.jintu.safecampus.dal.dao.AlarmInfoMapper;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.model.AlarmInfo;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.service.IAlarmInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 告警表 告警信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class AlarmInfoServiceImpl extends ServiceImpl<AlarmInfoMapper, AlarmInfo> implements IAlarmInfoService {

    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public QueryResponseResult<FindAlarmInfoListResponseDTO> findAlarmInfoList(FindAlarmInfoListRequestDTO requestDTO) {
        Page<FindAlarmInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindAlarmInfoListResponseDTO> iPage = baseMapper.findAlarmInfoList(page,requestDTO);
        QueryResult<FindAlarmInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public CommonResponseResult<FindAlarmInfoByIdResponseDTO> findAlarmInfoById(Long alarmInfoId) {
        AlarmInfo alarmInfo = this.getById(alarmInfoId);
        if (alarmInfo == null) {
            ExceptionCast.cast("查询的告警信息不存在！");
        }
        FindAlarmInfoByIdResponseDTO responseDTO = new FindAlarmInfoByIdResponseDTO();
        BeanUtils.copyProperties(alarmInfo,responseDTO);
        UnitInfo unitInfo = unitInfoMapper.selectOne(Wrappers.<UnitInfo>lambdaQuery().select(UnitInfo::getUnitName).eq(UnitInfo::getId, alarmInfo.getUnitInfoId()));
        if (unitInfo == null) {
            ExceptionCast.cast("该告警单位异常，请联系管理员！");
        }
        responseDTO.setUnitInfoName(unitInfo.getUnitName());
        return new CommonResponseResult<>(responseDTO);
    }
}
