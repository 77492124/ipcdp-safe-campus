package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.safecampus.dal.model.WatchList;
import org.apache.poi.ss.usermodel.Workbook;

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
    void saveShiftSetting(SaveShiftSettingBaseRequestDTO requestDTO);
    /**
     * 查询值班列表
     * @param requestDTO 查询条件
     * @return 值班列表
     */
    QueryResponseResult<FindWatchListResponseDTO> findWatchList(FindWatchListRequestDTO requestDTO);

    /**
     * 导出值班表
     * @param requestDTO 查询条件
     * @return  Workbook
     */
    Workbook exportWatchList(ExportWatchListRequestDTO requestDTO);
}
