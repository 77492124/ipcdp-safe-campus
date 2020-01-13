package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingResponseDTO;
import com.jintu.safecampus.dal.dao.NursingPostPersonMapper;
import com.jintu.safecampus.dal.dao.PointRequirementsPersonnelMapper;
import com.jintu.safecampus.dal.dao.PointRequirementsSettingMapper;
import com.jintu.safecampus.dal.model.PointRequirementsPersonnel;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;
import com.jintu.safecampus.service.IPointRequirementsPersonnelService;
import com.jintu.safecampus.service.IWatchListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 点位需求人员 点位需求人员表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class PointRequirementsPersonnelServiceImpl extends ServiceImpl<PointRequirementsPersonnelMapper, PointRequirementsPersonnel> implements IPointRequirementsPersonnelService {

    @Resource
    private NursingPostPersonMapper nursingPostPersonMapper;

    @Resource
    private IWatchListService watchListService;

    @Resource
    private PointRequirementsSettingMapper pointRequirementsSettingMapper;


    @Override
    public QueryResponseResult<FindShiftSettingResponseDTO> findShiftSetting(Long nursingPostTimeId) {
        List<FindShiftSettingResponseDTO> list = baseMapper.findShiftSetting(nursingPostTimeId);
        if (!list.isEmpty()) {
            for (FindShiftSettingResponseDTO findShiftSettingResponseDTO : list) {
                // 查询每个需求的负责人列表
                findShiftSettingResponseDTO.setPrincipals(baseMapper.findPrincipalList(findShiftSettingResponseDTO.getPointRequirementsSettingId()));
                // 查询每个需求需要的护学岗员工列表
                findShiftSettingResponseDTO.setNursingPostPersons(nursingPostPersonMapper.findNursingPostPersonLists(findShiftSettingResponseDTO.getUnitInfoId(),findShiftSettingResponseDTO.getPersonType()));
            }
        }
        QueryResult<FindShiftSettingResponseDTO> queryResult = new QueryResult<>(list,(long)list.size());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult saveShiftSetting(List<SaveShiftSettingRequestDTO> requestDTO) {
        PointRequirementsSetting setting = null;
        List<PointRequirementsPersonnel> insertPersonnel = null;
        for (SaveShiftSettingRequestDTO settingRequestDTO : requestDTO) {
            setting = pointRequirementsSettingMapper.selectById(settingRequestDTO.getPointRequirementsSettingId());
            if (setting == null) {
                ExceptionCast.cast("岗位需求错误");
            }
            if (settingRequestDTO.getNursingPostPersonIds().size() > setting.getNumberOfPersonnel()) {
                ExceptionCast.cast("所选护学岗人员数量不能超出配置数量！");
            }
            // 先删除之前的
            this.remove(Wrappers.<PointRequirementsPersonnel>lambdaQuery()
                    .eq(PointRequirementsPersonnel::getPointRequirementsSettingId,setting.getId()));
            insertPersonnel = new ArrayList<>();
            // 再把这次分配的人添加到点位需求人员列表
            for (Long nursingPostPersonId : settingRequestDTO.getNursingPostPersonIds()) {
                insertPersonnel.add(new PointRequirementsPersonnel()
                        .setNursingPostPersonId(nursingPostPersonId)
                        .setPointRequirementsSettingId(setting.getId())
                        .setCreatedId(settingRequestDTO.getCreatedId()));
            }
            this.saveBatch(insertPersonnel);
        }
        watchListService.saveShiftSetting(requestDTO);
        return ResponseResult.SUCCESS();
    }
}
