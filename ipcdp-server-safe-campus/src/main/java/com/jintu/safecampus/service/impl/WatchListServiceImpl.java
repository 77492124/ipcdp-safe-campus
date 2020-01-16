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
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.safecampus.common.dto.response.ExportWatchListDTO;
import com.jintu.safecampus.dal.dao.NursingPostPersonMapper;
import com.jintu.safecampus.dal.dao.PointRequirementsSettingMapper;
import com.jintu.safecampus.dal.dao.WatchListMapper;
import com.jintu.safecampus.dal.model.PointRequirementsSetting;
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
import java.util.stream.Collectors;

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

    @Resource
    private PointRequirementsSettingMapper pointRequirementsSettingMapper;

    @Resource
    private NursingPostPersonMapper nursingPostPersonMapper;

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

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult editWatchList(EditWatchListRequestDTO requestDTO) {
        WatchList watchList = this.getById(requestDTO.getId());
        if (watchList == null) {
            ExceptionCast.cast("编辑的值班不存在！");
        }
        PointRequirementsSetting setting = pointRequirementsSettingMapper.selectById(watchList.getPointRequirementsSettingId());
        if (setting == null) {
            ExceptionCast.cast("该值班需求不存在，请联系管理员！");
        }
        if (requestDTO.getPrincipalIds().size() > setting.getNumberOfPersonnel()) {
            ExceptionCast.cast("该值班人数大于设置人数！");
        }
        // 先删除之前的值班人员
        watchPersonnelListService.remove(Wrappers.<WatchPersonnelList>lambdaQuery().eq(WatchPersonnelList::getWatchListId,requestDTO.getId()));
        // 加入新想值班人员
        List<WatchPersonnelList> watchPersonnelLists = requestDTO.getPrincipalIds().stream()
                .map(s -> new WatchPersonnelList()
                .setWatchListId(requestDTO.getId())
                .setNursingPostPersonId(s))
                .collect(Collectors.toList());
        watchPersonnelListService.saveBatch(watchPersonnelLists);
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<FindWatchListByIdResponseDTO> findWatchListById(Long watchListId) {
        WatchList watchList = this.getById(watchListId);
        if (watchList == null) {
            ExceptionCast.cast("值班不存在！");
        }
        PointRequirementsSetting setting = pointRequirementsSettingMapper.selectById(watchList.getPointRequirementsSettingId());
        if (setting == null) {
            ExceptionCast.cast("该值班需求不存在，请联系管理员！");
        }
        FindWatchListByIdResponseDTO responseDTO = new FindWatchListByIdResponseDTO();
        responseDTO.setNumberOfPersonnel(setting.getNumberOfPersonnel());
        // 查询该单位下此类型的护学岗人员
        List<FindShiftSettingDTO> nursingPostPersonLists = nursingPostPersonMapper.findNursingPostPersonLists(watchList.getUnitInfoId(), setting.getPersonType());
        responseDTO.setNursingPostPersons(nursingPostPersonLists);
        // 查询值班负责列表
        responseDTO.setPrincipals(baseMapper.findPrincipals(watchListId));
        return new CommonResponseResult<>(responseDTO);
    }
}
