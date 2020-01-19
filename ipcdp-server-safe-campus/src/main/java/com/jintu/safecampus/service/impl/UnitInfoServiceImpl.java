package com.jintu.safecampus.service.impl;

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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.dal.dao.EmployeeJobRelationMapper;
import com.jintu.safecampus.dal.dao.EmployeeMapper;
import com.jintu.safecampus.dal.dao.JobInfoMapper;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.model.Employee;
import com.jintu.safecampus.dal.model.EmployeeJobRelation;
import com.jintu.safecampus.dal.model.JobInfo;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.service.IUnitInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 单位信息表 单位信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class UnitInfoServiceImpl extends ServiceImpl<UnitInfoMapper, UnitInfo> implements IUnitInfoService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private JobInfoMapper jobInfoMapper;

    @Resource
    private EmployeeJobRelationMapper employeeJobRelationMapper;

    @Override
    public QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO) {
        Page<FindUnitInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindUnitInfoListResponseDTO> iPage = baseMapper.findUnitInfoList(page,requestDTO);
        QueryResult<FindUnitInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult saveUnitInfo(SaveUnitInfoRequestDTO requestDTO) {
        int count = this.count(Wrappers.<UnitInfo>lambdaQuery().eq(UnitInfo::getUnitName, requestDTO.getUnitName()));
        if (count > 0) {
            ExceptionCast.cast("请勿重复添加单位！");
        }
        int userNameCount = employeeMapper.selectCount(Wrappers.<Employee>lambdaQuery().eq(Employee::getUserName, requestDTO.getUserName()));
        if (userNameCount > 0) {
            ExceptionCast.cast("请勿重复添加账号！");
        }
        UnitInfo unitInfo = new UnitInfo();
        BeanUtils.copyProperties(requestDTO,unitInfo);
        this.save(unitInfo);
        Employee employee = new Employee().setUnitInfoId(unitInfo.getId()).setEmployeeName("管理员")
                .setUserName(requestDTO.getUserName()).setPassWord(requestDTO.getPassWord()).setAdminMark(true).setCreatedId(requestDTO.getCreatedId());
        employeeMapper.insert(employee);
        // 如果是学校，就把系统创建的默认角色给他（默认角色的单位id为1，初始化系统的时候创建的）
        if (unitInfo.getUnitType() == 0){
            JobInfo jobInfo = jobInfoMapper.selectOne(Wrappers.<JobInfo>lambdaQuery().select(JobInfo::getId).eq(JobInfo::getUnitInfoId, 1L));
            if (jobInfo == null) {
                ExceptionCast.cast("系统错误,请联系管理员！");
            }
            employeeJobRelationMapper.insert(new EmployeeJobRelation().setEmployeeId(employee.getId()).setJobInfoId(jobInfo.getId()).setCreatedId(requestDTO.getCreatedId()));
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public CommonResponseResult<EditUnitInfoResponseDTO> editUnitInfo(EditUnitInfoRequestDTO requestDTO) {
        int unitInfoCount = this.count(Wrappers.<UnitInfo>lambdaQuery().eq(UnitInfo::getId, requestDTO.getId()));
        if (unitInfoCount <= 0){
            ExceptionCast.cast("修改单位不存在！");
        }
        int employeeCount = employeeMapper.selectCount(Wrappers.<Employee>lambdaQuery().eq(Employee::getId, requestDTO.getEmployeeId()).eq(Employee::getUnitInfoId,requestDTO.getId()));
        if (employeeCount <= 0){
            ExceptionCast.cast("修改单位管理员不存在！");
        }
        UnitInfo unitInfo = new UnitInfo();
        BeanUtils.copyProperties(requestDTO,unitInfo);
        List<Long> ids = this.list(Wrappers.<UnitInfo>lambdaQuery().select(UnitInfo::getId).eq(UnitInfo::getUnitName, requestDTO.getUnitName())).stream().map(UnitInfo::getId).collect(Collectors.toList());
        if (!ids.isEmpty()) {
            if (!ids.contains(unitInfo.getId())){
                ExceptionCast.cast("请勿重复添加单位！");
            }
        }
        this.updateById(unitInfo);
        Employee employee = new Employee().setId(requestDTO.getEmployeeId()).setPassWord(requestDTO.getPassWord());
        employeeMapper.updateById(employee);
        EditUnitInfoResponseDTO responseDTO = baseMapper.findUnitInfoById(requestDTO.getId());
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public CommonResponseResult<EditUnitInfoResponseDTO> findUnitInfoById(Long unitInfoId) {
        EditUnitInfoResponseDTO responseDTO = baseMapper.findUnitInfoById(unitInfoId);
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult delUnitInfo(Long unitInfoId) {
        int unitInfoCount = this.count(Wrappers.<UnitInfo>lambdaQuery().eq(UnitInfo::getId, unitInfoId));
        if (unitInfoCount <= 0){
            ExceptionCast.cast("删除单位不存在！");
        }
        this.removeById(unitInfoId);
        employeeMapper.delete(Wrappers.<Employee>lambdaQuery().eq(Employee::getUnitInfoId,unitInfoId));
        return ResponseResult.SUCCESS();
    }

    @Override
    public QueryResponseResult<FindSchoolListResponseDTO> findSchoolList(String unitName) {
        List<FindSchoolListResponseDTO> list=baseMapper.findSchoolList(unitName);
        QueryResult<FindSchoolListResponseDTO> result = new QueryResult<>(list, null);
        return new QueryResponseResult<FindSchoolListResponseDTO>(result);
    }
}
