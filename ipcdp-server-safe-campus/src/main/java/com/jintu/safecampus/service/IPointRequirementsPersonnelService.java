package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingBaseResponseDTO;
import com.jintu.safecampus.dal.model.PointRequirementsPersonnel;

/**
 * <p>
 * 点位需求人员 点位需求人员表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IPointRequirementsPersonnelService extends IService<PointRequirementsPersonnel> {
    /**
     * 根据护学岗时间id查询排班列表
     * @param requestDTO 护学岗时间id
     * @return  排班列表
     */
    CommonResponseResult<FindShiftSettingBaseResponseDTO> findShiftSetting(FindShiftSettingRequestDTO requestDTO);
    /**
     * 保存排班设置
     * @param requestDTO 排班信息
     * @return 是否成功
     */
    ResponseResult saveShiftSetting(SaveShiftSettingBaseRequestDTO requestDTO);
}
