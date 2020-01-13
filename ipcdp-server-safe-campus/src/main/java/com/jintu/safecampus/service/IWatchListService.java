package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.safecampus.dal.model.WatchList;

import java.util.List;

/**
 * <p>
 * 值班表 值班表信息 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IWatchListService extends IService<WatchList> {
    /**
     * 保存排班设置
     * @param requestDTO 排班设置
     */
    void saveShiftSetting(List<SaveShiftSettingRequestDTO> requestDTO);
}
