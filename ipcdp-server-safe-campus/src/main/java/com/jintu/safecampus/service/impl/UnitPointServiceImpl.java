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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.dal.dao.UnitPointMapper;
import com.jintu.safecampus.dal.model.UnitPoint;
import com.jintu.safecampus.service.IUnitPointService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单位点位 单位点位信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class UnitPointServiceImpl extends ServiceImpl<UnitPointMapper, UnitPoint> implements IUnitPointService {

    @Override
    public QueryResponseResult<FindUnitPointListResponseDTO> findUnitPointList(FindUnitPointListRequestDTO requestDTO) {
        Page<FindUnitPointListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindUnitPointListResponseDTO> iPage = baseMapper.findUnitPointList(page,requestDTO);
        QueryResult<FindUnitPointListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveUnitPoint(SaveUnitPointRequestDTO requestDTO) {
        int count = this.count(Wrappers.<UnitPoint>lambdaQuery().eq(UnitPoint::getUnitInfoId, requestDTO.getUnitInfoId()).eq(UnitPoint::getPointName, requestDTO.getPointName()));
        if (count > 0) {
            ExceptionCast.cast("点位名称不能重复！");
        }
        UnitPoint unitPoint = new UnitPoint();
        BeanUtils.copyProperties(requestDTO,unitPoint);
        this.save(unitPoint);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editUnitPoint(EditUnitPointRequestDTO requestDTO) {
        int count = this.count(Wrappers.<UnitPoint>lambdaQuery().eq(UnitPoint::getUnitInfoId, requestDTO.getUnitInfoId()).eq(UnitPoint::getPointName, requestDTO.getPointName()).ne(UnitPoint::getId,requestDTO.getId()));
        if (count > 0) {
            ExceptionCast.cast("点位名称不能重复！");
        }
        UnitPoint unitPoint = new UnitPoint();
        BeanUtils.copyProperties(requestDTO,unitPoint);
        this.updateById(unitPoint);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult delUnitPoint(Long unitPointId) {
        int count = this.count(Wrappers.<UnitPoint>lambdaQuery().eq(UnitPoint::getId, unitPointId));
        if (count <= 0) {
            ExceptionCast.cast("该点位不存在！");
        }
        // TODO: 2020/1/10 删除判断条件有待商榷
        return ResponseResult.SUCCESS();
    }
}
