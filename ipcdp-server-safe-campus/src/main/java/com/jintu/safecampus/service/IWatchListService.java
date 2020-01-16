package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWorkInRealTimeStaffListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostTaskRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWorkInRealTimeStaffResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostTaskResponseDTO;
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
    /**
     * 编辑值班列表
     * @param requestDTO 值班信息
     * @return 是否成功
     */
    ResponseResult editWatchList(EditWatchListRequestDTO requestDTO);
    /**
     * 根据值班id查询编辑详情
     * @param watchListId 值班id
     * @return 详情
     */
    CommonResponseResult<FindWatchListByIdResponseDTO> findWatchListById(Long watchListId);
    /**
     * 护学岗管理展现页
     * @param requestDTO 查询条件
     * @return 展示数据
     */
    CommonResponseResult<FindWorkInRealTimeStaffResponseDTO> findWorkInRealTimeStaffList(FindWorkInRealTimeStaffListRequestDTO requestDTO);

    /**
     * 护学岗APP任务查询
     * @param requestDTO
     * @return
     */
    QueryResponseResult<NursingPostTaskResponseDTO> findNursingPostTask(NursingPostTaskRequestDTO requestDTO);
}
