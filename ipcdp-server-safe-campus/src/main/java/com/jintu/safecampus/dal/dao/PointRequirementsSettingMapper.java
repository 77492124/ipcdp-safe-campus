package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;

import java.util.List;

/**
 * <p>
 * 点位需求设置 点位需求设置表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface PointRequirementsSettingMapper extends BaseMapper<PointRequirementsSetting> {
    /**
     * 根据护学岗时间id查询人员配置列表
     * @param nursingPostTimeId 护学岗时间id
     * @return 人员配置列表
     */
    List<FindPointSettingListResponseDTO> findPointRequirementsSettingList(Long nursingPostTimeId);
}
