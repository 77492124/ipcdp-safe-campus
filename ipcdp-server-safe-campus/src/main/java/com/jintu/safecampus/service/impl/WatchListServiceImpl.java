package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingRequestDTO;
import com.jintu.safecampus.dal.dao.WatchListMapper;
import com.jintu.safecampus.dal.model.WatchList;
import com.jintu.safecampus.dal.model.WatchPersonnelList;
import com.jintu.safecampus.service.IWatchListService;
import com.jintu.safecampus.service.IWatchPersonnelListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public void saveShiftSetting(List<SaveShiftSettingRequestDTO> requestDTO) {
        WatchList watchList = null;
        List<WatchPersonnelList> watchPersonnelLists = null;
        for (SaveShiftSettingRequestDTO dto : requestDTO) {
            int count = this.count(Wrappers.<WatchList>lambdaQuery()
                    .eq(WatchList::getUnitInfoId, dto.getUnitInfoId())
                    .eq(WatchList::getNursingPostTimeId, dto.getNursingPostTimeId())
                    .eq(WatchList::getUnitPointId, dto.getUnitPointId())
                    .eq(WatchList::getPointRequirementsSettingId, dto.getPointRequirementsSettingId())
                    .eq(WatchList::getWorkingDate, dto.getWorkingDate()));
            if (count > 0) {
                ExceptionCast.cast("请勿重复添加排班！");
            }
            watchList = new WatchList()
                    .setUnitInfoId(dto.getUnitInfoId())
                    .setNursingPostTimeId(dto.getNursingPostTimeId())
                    .setUnitPointId(dto.getUnitPointId())
                    .setPointRequirementsSettingId(dto.getPointRequirementsSettingId())
                    .setWorkingDate( dto.getWorkingDate())
                    .setCreatedId(dto.getCreatedId());
            this.save(watchList);
            watchPersonnelLists = new ArrayList<>();
            for (Long nursingPostPersonId : dto.getNursingPostPersonIds()) {
                watchPersonnelLists.add(new WatchPersonnelList().setWatchListId(watchList.getId())
                        .setNursingPostPersonId(nursingPostPersonId).setCreatedId(dto.getCreatedId()));
            }
            watchPersonnelListService.saveBatch(watchPersonnelLists);
        }
    }
}
