package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import com.jintu.safecampus.dal.dao.NursingPostPersonMapper;
import com.jintu.safecampus.dal.dao.NursingPostPersonWorkRecordMapper;
import com.jintu.safecampus.dal.dao.WatchListMapper;
import com.jintu.safecampus.dal.model.NursingPostPerson;
import com.jintu.safecampus.dal.model.NursingPostPersonWorkRecord;
import com.jintu.safecampus.dal.model.WatchList;
import com.jintu.safecampus.service.INursingPostPersonWorkRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 护学岗人员上班记录  服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
@Service
public class NursingPostPersonWorkRecordServiceImpl extends ServiceImpl<NursingPostPersonWorkRecordMapper, NursingPostPersonWorkRecord> implements INursingPostPersonWorkRecordService {

    @Resource
    private NursingPostPersonMapper nursingPostPersonMapper;
    @Resource
    private WatchListMapper watchListMapper;

    @Transactional
    @Override
    public ResponseResult nursingPostWork(NursingPostWorkRequestDTO nursingPostWorkRequestDTO) {

        WatchList watchList = watchListMapper.selectById(nursingPostWorkRequestDTO.getWatchListId());
        if(ObjectUtils.isEmpty(watchList)){
            ExceptionCast.cast("查询不到值班表");
        }
        //添加护学岗人员上班记录表
        NursingPostPersonWorkRecord nursingPostPersonWorkRecord = new NursingPostPersonWorkRecord();
        nursingPostPersonWorkRecord.setNursingPostPersonId(nursingPostWorkRequestDTO.getNursingPostPersonId());
        nursingPostPersonWorkRecord.setRecordType(nursingPostWorkRequestDTO.getRecordType());
        nursingPostPersonWorkRecord.setWatchListId(nursingPostWorkRequestDTO.getWatchListId());

        boolean save = this.save(nursingPostPersonWorkRecord);
        if (!save) {
            ExceptionCast.cast("工作记录添加失败");
        }
        //修改护学岗人员上班状态
        boolean update = new LambdaUpdateChainWrapper<>(nursingPostPersonMapper)
                .eq(NursingPostPerson::getId, nursingPostWorkRequestDTO.getNursingPostPersonId())
                .set(NursingPostPerson::getWorkStatus, nursingPostWorkRequestDTO.getRecordType())
                .update();
        if (!update) {
            ExceptionCast.cast("修改护学岗人员上班状态失败");
        }
        return ResponseResult.SUCCESS();
    }
}
