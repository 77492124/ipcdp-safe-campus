package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonUnWorkRecordRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonUnWorkRecordResponseDTO;
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
import java.util.ArrayList;
import java.util.List;

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
    public ResponseResult nursingPostWork(NursingPostWorkRequestDTO requestDTO) {

        NursingPostPerson nursingPostPerson = nursingPostPersonMapper.selectById(requestDTO.getNursingPostPersonId());
        if (ObjectUtils.isEmpty(nursingPostPerson)) {
            ExceptionCast.cast("查询不到护学岗人员信息");
        }
        //记录类型 0：下班；1：上班
        if(requestDTO.getRecordType()==0 && nursingPostPerson.getWorkStatus()== false){
            ExceptionCast.cast("已经点过下班，请勿重新点击");
        }
        if(requestDTO.getRecordType()==1 && nursingPostPerson.getWorkStatus()== true){
            ExceptionCast.cast("已经点过上班，请勿重新点击");
        }

        WatchList watchList = watchListMapper.selectById(requestDTO.getWatchListId());
        if(ObjectUtils.isEmpty(watchList)){
            ExceptionCast.cast("查询不到值班表");
        }
        //添加护学岗人员上班记录表
        NursingPostPersonWorkRecord nursingPostPersonWorkRecord = new NursingPostPersonWorkRecord();
        BeanUtils.copyProperties(requestDTO,nursingPostPersonWorkRecord);
        boolean save = this.save(nursingPostPersonWorkRecord);

        if (!save) {
            ExceptionCast.cast("工作记录添加失败");
        }
        //修改护学岗人员上班状态
        boolean update = new LambdaUpdateChainWrapper<>(nursingPostPersonMapper)
                .eq(NursingPostPerson::getId, requestDTO.getNursingPostPersonId())
                .set(NursingPostPerson::getWorkStatus, requestDTO.getRecordType())
                .update();
        if (!update) {
            ExceptionCast.cast("修改护学岗人员上班状态失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public QueryResponseResult<NursingPostPersonUnWorkRecordResponseDTO> findNursingPostPersonUnWorkRecord(NursingPostPersonUnWorkRecordRequestDTO requestDTO) {
        Page page = new Page(requestDTO.getCurrent(), requestDTO.getSize());
        page.addOrder(OrderItem.desc("wl.working_date"));
        IPage<NursingPostPersonUnWorkRecordResponseDTO> iPage=nursingPostPersonMapper.findNursingPostPersonUnWorkRecord(page,requestDTO);
        QueryResult<NursingPostPersonUnWorkRecordResponseDTO> result = new QueryResult<>(iPage.getRecords(), iPage.getTotal());
        return new QueryResponseResult<>(result);
    }
}
