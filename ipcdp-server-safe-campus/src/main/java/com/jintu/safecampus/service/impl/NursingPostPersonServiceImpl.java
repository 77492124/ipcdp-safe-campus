package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import com.jintu.safecampus.dal.dao.NursingPostPersonMapper;
import com.jintu.safecampus.dal.model.NursingPostPerson;
import com.jintu.safecampus.service.INursingPostPersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 护学岗人员 护学岗人员表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class NursingPostPersonServiceImpl extends ServiceImpl<NursingPostPersonMapper, NursingPostPerson> implements INursingPostPersonService {

    @Override
    public QueryResponseResult<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(FindNursingPostPersonListRequestDTO requestDTO) {
        Page<FindNursingPostPersonListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindNursingPostPersonListResponseDTO> iPage = baseMapper.findNursingPostPersonList(page,requestDTO);
        QueryResult<FindNursingPostPersonListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveNursingPostPerson(SaveNursingPostPersonRequestDTO requestDTO) {
        int count = this.count(Wrappers.<NursingPostPerson>lambdaQuery().eq(NursingPostPerson::getUserName, requestDTO.getUserName()));
        if (count > 0) {
            ExceptionCast.cast("账号不能重复！");
        }
        NursingPostPerson nursingPostPerson = new NursingPostPerson();
        BeanUtils.copyProperties(requestDTO,nursingPostPerson);
        this.save(nursingPostPerson);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editNursingPostPerson(EditNursingPostPersonRequestDTO requestDTO) {
        int count = this.count(Wrappers.<NursingPostPerson>lambdaQuery().eq(NursingPostPerson::getId, requestDTO.getId()));
        if (count <= 0) {
            ExceptionCast.cast("该护学岗人员不存在！");
        }
        NursingPostPerson nursingPostPerson = new NursingPostPerson();
        BeanUtils.copyProperties(requestDTO,nursingPostPerson);
        this.updateById(nursingPostPerson);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult delNursingPostPerson(Long nursingPostPersonId) {
        int count = this.count(Wrappers.<NursingPostPerson>lambdaQuery().eq(NursingPostPerson::getId, nursingPostPersonId));
        if (count <= 0) {
            ExceptionCast.cast("该护学岗人员不存在！");
        }
        // TODO: 2020/1/10 删除逻辑有待商榷
        return ResponseResult.SUCCESS();
    }
}
