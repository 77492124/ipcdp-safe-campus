package com.jintu.safecampus.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelStyleType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.safecampus.common.dto.response.ExportWatchListDTO;
import com.jintu.safecampus.dal.dao.WatchListMapper;
import com.jintu.safecampus.dal.model.WatchList;
import com.jintu.safecampus.dal.model.WatchPersonnelList;
import com.jintu.safecampus.service.IWatchListService;
import com.jintu.safecampus.service.IWatchPersonnelListService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 值班表 值班表信息 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class WatchListServiceImpl extends ServiceImpl<WatchListMapper, WatchList> implements IWatchListService {
    @Resource
    private IWatchPersonnelListService watchPersonnelListService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveShiftSetting(SaveShiftSettingBaseRequestDTO requestDTO) {
        WatchList watchList = null;
        List<WatchPersonnelList> watchPersonnelLists = null;
        for (LocalDate workingDate : requestDTO.getWorkingDates()) {
            for (SaveShiftSettingRequestDTO dto : requestDTO.getShiftSettings()) {
                int count = this.count(Wrappers.<WatchList>lambdaQuery()
                        .eq(WatchList::getUnitInfoId, requestDTO.getUnitInfoId())
                        .eq(WatchList::getNursingPostTimeId, requestDTO.getNursingPostTimeId())
                        .eq(WatchList::getUnitPointId, dto.getUnitPointId())
                        .eq(WatchList::getPointRequirementsSettingId, dto.getPointRequirementsSettingId())
                        .eq(WatchList::getWorkingDate, workingDate));
                if (count > 0) {
                    ExceptionCast.cast("请勿重复添加排班！");
                }
                watchList = new WatchList()
                        .setUnitInfoId(requestDTO.getUnitInfoId())
                        .setNursingPostTimeId(requestDTO.getNursingPostTimeId())
                        .setUnitPointId(dto.getUnitPointId())
                        .setPointRequirementsSettingId(dto.getPointRequirementsSettingId())
                        .setWorkingDate(workingDate)
                        .setCreatedId(requestDTO.getCreatedId());
                this.save(watchList);
                watchPersonnelLists = new ArrayList<>();
                for (Long nursingPostPersonId : dto.getNursingPostPersonIds()) {
                    watchPersonnelLists.add(new WatchPersonnelList().setWatchListId(watchList.getId())
                            .setNursingPostPersonId(nursingPostPersonId).setCreatedId(requestDTO.getCreatedId()));
                }
                watchPersonnelListService.saveBatch(watchPersonnelLists);
            }
        }
    }

    @Override
    public QueryResponseResult<FindWatchListResponseDTO> findWatchList(FindWatchListRequestDTO requestDTO) {
        Page<FindWatchListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindWatchListResponseDTO> iPage = baseMapper.findWatchList(page,requestDTO);
        List<FindWatchListResponseDTO> records = iPage.getRecords();
        // 此处可以优化为一对多查询
        for (FindWatchListResponseDTO record : records) {
            record.setPrincipalList(baseMapper.findPrincipalList(record.getId()));
        }
        QueryResult<FindWatchListResponseDTO> queryResult = new QueryResult<>(records,iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public Workbook exportWatchList(ExportWatchListRequestDTO requestDTO) {
        LocalDate localDate = LocalDate.now();
        requestDTO.setBeginDate(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        requestDTO.setEndDate(localDate.with(TemporalAdjusters.lastDayOfMonth()));
        List<ExportWatchListDTO> list = baseMapper.findExportWatchList(requestDTO);
        if (list.isEmpty()) {
            ExceptionCast.cast("导出列表为空！");
        }
        String title = String.format("%s 值班表", localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        ExportParams exportParams = new ExportParams(title, "值班表");
        exportParams.setStyle(ExcelStyleType.BORDER.getClazz());
        return ExcelExportUtil.exportExcel(exportParams,ExportWatchListDTO.class, list);
    }
}
