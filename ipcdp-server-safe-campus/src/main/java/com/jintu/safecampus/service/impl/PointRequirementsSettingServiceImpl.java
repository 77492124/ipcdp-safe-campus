package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditPointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
import com.jintu.safecampus.dal.dao.PointRequirementsPersonnelMapper;
import com.jintu.safecampus.dal.dao.PointRequirementsSettingMapper;
import com.jintu.safecampus.dal.model.PointRequirementsPersonnel;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;
import com.jintu.safecampus.service.IPointRequirementsSettingService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 点位需求设置 点位需求设置表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class PointRequirementsSettingServiceImpl extends ServiceImpl<PointRequirementsSettingMapper, PointRequirementsSetting> implements IPointRequirementsSettingService {

    @Resource
    private PointRequirementsPersonnelMapper pointRequirementsPersonnelMapper;

    @Override
    public QueryResponseResult<FindPointSettingListResponseDTO> findPointRequirementsSettingList(Long nursingPostTimeId) {
        List<FindPointSettingListResponseDTO> list = baseMapper.findPointRequirementsSettingList(nursingPostTimeId);
        QueryResult<FindPointSettingListResponseDTO> queryResult = new QueryResult<>(list, (long) list.size());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult savePointRequirementsSetting(SavePointRequirementsSettingRequestDTO requestDTO) {
        for (SavePointRequirementsSettingDTO setting : requestDTO.getSettings()) {
            // 时间点位所需人员类型需保持唯一
            int count = this.count(Wrappers.<PointRequirementsSetting>lambdaQuery()
                    .eq(PointRequirementsSetting::getUnitPointId, requestDTO.getUnitPointId())
                    .eq(PointRequirementsSetting::getNursingPostTimeId, requestDTO.getNursingPostTimeId())
                    .eq(PointRequirementsSetting::getPersonType, setting.getPersonType()));
            if (count > 0) {
                ExceptionCast.cast("请勿重复添加！");
            }
            this.save(new PointRequirementsSetting()
                    .setNursingPostTimeId(requestDTO.getNursingPostTimeId())
                    .setUnitPointId(requestDTO.getUnitPointId())
                    .setPersonType(setting.getPersonType())
                    .setNumberOfPersonnel(setting.getNumberOfPersonnel())
                    .setAreaRadius(setting.getAreaRadius())
                    .setCreatedId(requestDTO.getCreatedId()));

        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editPointRequirementsSetting(EditPointRequirementsSettingRequestDTO requestDTO) {
        int count = this.count(Wrappers.<PointRequirementsSetting>lambdaQuery().eq(PointRequirementsSetting::getId, requestDTO.getId()));
        if (count <= 0) {
            ExceptionCast.cast("配置不存在！");
        }
        PointRequirementsSetting setting = new PointRequirementsSetting();
        BeanUtils.copyProperties(requestDTO,setting);
        this.updateById(setting);
        return ResponseResult.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult delPointRequirementsSetting(Long id) {
        int count = this.count(Wrappers.<PointRequirementsSetting>lambdaQuery().eq(PointRequirementsSetting::getId, id));
        if (count <= 0) {
            ExceptionCast.cast("配置不存在！");
        }
        // 先删除子表
        pointRequirementsPersonnelMapper.delete(Wrappers.<PointRequirementsPersonnel>lambdaQuery().eq(PointRequirementsPersonnel::getPointRequirementsSettingId,id));
        this.removeById(id);
        return ResponseResult.SUCCESS();
    }
}
