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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
import com.jintu.safecampus.dal.dao.NursingPostTimeMapper;
import com.jintu.safecampus.dal.dao.PointRequirementsSettingMapper;
import com.jintu.safecampus.dal.model.NursingPostTime;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;
import com.jintu.safecampus.service.INursingPostTimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 护学岗时间 护学岗时间表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class NursingPostTimeServiceImpl extends ServiceImpl<NursingPostTimeMapper, NursingPostTime> implements INursingPostTimeService {

    @Resource
    private PointRequirementsSettingMapper pointRequirementsSettingMapper;

    @Override
    public QueryResponseResult<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(FindNursingPostTimeListRequestDTO requestDTO) {
        Page<FindNursingPostTimeListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindNursingPostTimeListResponseDTO> iPage = baseMapper.findNursingPostTimeList(page,requestDTO);
        QueryResult<FindNursingPostTimeListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveNursingPostTime(SaveNursingPostTimeRequestDTO requestDTO) {
        int count = this.count(Wrappers.<NursingPostTime>lambdaQuery().eq(NursingPostTime::getUnitInfoId, requestDTO.getUnitInfoId()).eq(NursingPostTime::getTimeName, requestDTO.getTimeName()));
        if (count > 0) {
            ExceptionCast.cast("名称不能重复！");
        }
        NursingPostTime postTime = new NursingPostTime();
        BeanUtils.copyProperties(requestDTO,postTime);
        this.save(postTime);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editNursingPostTime(EditNursingPostTimeRequestDTO requestDTO) {
        int count = this.count(Wrappers.<NursingPostTime>lambdaQuery().eq(NursingPostTime::getUnitInfoId, requestDTO.getUnitInfoId())
                .eq(NursingPostTime::getTimeName, requestDTO.getTimeName()).ne(NursingPostTime::getId,requestDTO.getId()));
        if (count > 0) {
            ExceptionCast.cast("名称不能重复！");
        }
        NursingPostTime postTime = new NursingPostTime();
        BeanUtils.copyProperties(requestDTO,postTime);
        this.updateById(postTime);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult delNursingPostTime(Long nursingPostTimeId) {
        int count = this.count(Wrappers.<NursingPostTime>lambdaQuery().eq(NursingPostTime::getId, nursingPostTimeId));
        if (count > 0) {
            ExceptionCast.cast("该单位护学岗时间不存在！");
        }
        int settingCount = pointRequirementsSettingMapper.selectCount(Wrappers.<PointRequirementsSetting>lambdaQuery().eq(PointRequirementsSetting::getNursingPostTimeId, nursingPostTimeId));
        if (settingCount > 0) {
            ExceptionCast.cast("请先删除该护学岗时间下的点位人员配置！");
        }
        this.removeById(nursingPostTimeId);
        return ResponseResult.SUCCESS();
    }
}
