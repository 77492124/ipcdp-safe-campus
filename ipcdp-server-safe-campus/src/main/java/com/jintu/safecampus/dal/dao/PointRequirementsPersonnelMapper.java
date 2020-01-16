package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingResponseDTO;
import com.jintu.safecampus.dal.model.PointRequirementsPersonnel;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 点位需求人员 点位需求人员表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface PointRequirementsPersonnelMapper extends BaseMapper<PointRequirementsPersonnel> {
    /**
     * 根据护学岗时间id查询排班列表
     * @param nursingPostTimeId 护学岗时间id
     * @return  排班列表
     */
    List<FindShiftSettingResponseDTO> findShiftSetting(Long nursingPostTimeId);

    /**
     * 查询负责人列表
     * @param id 点位需求设置id
     * @return 列表
     */
    List<FindShiftSettingDTO> findPrincipalList(Long id);

    /**
     * 查询护学岗时间值班时间列表
     * @param requestDTO 查询条件
     * @return 值班时间列表
     */
    List<LocalDate> findPointDutyDates(@Param("dto") FindShiftSettingRequestDTO requestDTO);
}
