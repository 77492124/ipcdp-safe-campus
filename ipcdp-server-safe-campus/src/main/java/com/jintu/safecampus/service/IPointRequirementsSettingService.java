package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditPointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;

/**
 * <p>
 * 点位需求设置 点位需求设置表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IPointRequirementsSettingService extends IService<PointRequirementsSetting> {
    /**
     * 根据护学岗时间id查询人员配置列表
     * @param nursingPostTimeId 护学岗时间id
     * @return 人员配置列表
     */
    QueryResponseResult<FindPointSettingListResponseDTO> findPointRequirementsSettingList(Long nursingPostTimeId);
    /**
     * 添加时间点位人员配置
     * @param requestDTO 人员配置
     * @return 是否成功
     */
    ResponseResult savePointRequirementsSetting(SavePointRequirementsSettingRequestDTO requestDTO);
    /**
     * 编辑时间点位人员配置
     * @param requestDTO 人员配置
     * @return 是否成功
     */
    ResponseResult editPointRequirementsSetting(EditPointRequirementsSettingRequestDTO requestDTO);
    /**
     * 根据id删除时间点位人员配置
     * @param id id
     * @return 是否成功
     */
    ResponseResult delPointRequirementsSetting(Long id);
}
