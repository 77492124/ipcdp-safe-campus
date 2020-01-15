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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolResourcesListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.SafeEmployeeLoginResponseDTO;
import com.jintu.safecampus.common.util.BusinessUtils;
import com.jintu.safecampus.dal.dao.EmployeeMapper;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.model.Employee;
import com.jintu.safecampus.dal.model.EmployeeJobRelation;
import com.jintu.safecampus.dal.model.SchoolSysResources;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.service.IEmployeeJobRelationService;
import com.jintu.safecampus.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 员工表 员工信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Resource
    private BusinessUtils businessUtils;

    @Resource
    private IEmployeeJobRelationService employeeJobRelationService;

    @Override
    public CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(EmployeeLoginRequestDTO requestDTO) {
        Employee employee = this.getOne(Wrappers.<Employee>lambdaQuery().eq(Employee::getUserName, requestDTO.getUserName()));
        if (employee == null) {
            ExceptionCast.cast("账号不存在！");
        }
        if (!requestDTO.getPassWord().equalsIgnoreCase(employee.getPassWord())) {
            ExceptionCast.cast("账号或密码错误！");
        }
        EmployeeLoginResponseDTO responseDTO = new EmployeeLoginResponseDTO();
        BeanUtils.copyProperties(employee,responseDTO);
        UnitInfo unitInfo = unitInfoMapper.selectOne(Wrappers.<UnitInfo>lambdaQuery().select(UnitInfo::getUnitName,UnitInfo::getUnitType,UnitInfo::getLongitude,UnitInfo::getLatitude).eq(UnitInfo::getId, employee.getUnitInfoId()));
        if (unitInfo == null) {
            ExceptionCast.cast("该用户工作单位数据异常，请联系管理员！");
        }
        if (unitInfo.getUnitType() != 0) {
            ExceptionCast.cast("账号不存在！");
        }
        responseDTO.setUnitInfoName(unitInfo.getUnitName());
        responseDTO.setLongitude(unitInfo.getLongitude());
        responseDTO.setLatitude(unitInfo.getLatitude());
        List<SchoolSysResources> list = baseMapper.findSysResourcesByEmployeeId(employee.getId());
        responseDTO.setSchoolSysResources(businessUtils.findChildList(null, list));
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public QueryResponseResult<FindEmployeeListResponseDTO> findEmployeeList(FindEmployeeListRequestDTO requestDTO) {
        Page<FindEmployeeListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindEmployeeListResponseDTO> iPage = baseMapper.findEmployeeList(page,requestDTO);
        QueryResult<FindEmployeeListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult saveEmployee(SaveEmployeeRequestDTO requestDTO) {
        int userNameCount = this.count(Wrappers.<Employee>lambdaQuery().eq(Employee::getUserName, requestDTO.getUserName()));
        if (userNameCount > 0) {
            ExceptionCast.cast("员工账号已存在！");
        }
        int nameCount = this.count(Wrappers.<Employee>lambdaQuery().eq(Employee::getUnitInfoId, requestDTO.getUnitInfoId()).eq(Employee::getEmployeeName, requestDTO.getEmployeeName()));
        if (nameCount > 0) {
            ExceptionCast.cast("员工名称已存在！");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(requestDTO,employee);
        employee.setAdminMark(false);
        this.save(employee);
        List<EmployeeJobRelation> employeeJobRelations = new ArrayList<>();
        for (Long jobInfoId : requestDTO.getJobInfoIds()) {
            employeeJobRelations.add(new EmployeeJobRelation().setJobInfoId(jobInfoId).setEmployeeId(employee.getId()).setCreatedId(requestDTO.getCreatedId()));
        }
        employeeJobRelationService.saveBatch(employeeJobRelations);
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<FindEmployeeByIdResponseDTO> findEmployeeById(Long employeeId) {
        Employee employee = this.getOne(Wrappers.<Employee>lambdaQuery()
                .select(Employee::getId, Employee::getEmployeeName, Employee::getGender, Employee::getTelephone, Employee::getUserName, Employee::getPassWord)
                .eq(Employee::getId, employeeId));
        if (employee == null) {
            ExceptionCast.cast("该员工不存在！");
        }
        FindEmployeeByIdResponseDTO responseDTO = new FindEmployeeByIdResponseDTO();
        BeanUtils.copyProperties(employee,responseDTO);
        List<Long> collect = employeeJobRelationService.list(Wrappers.<EmployeeJobRelation>lambdaQuery()
                .select(EmployeeJobRelation::getJobInfoId)
                .eq(EmployeeJobRelation::getEmployeeId, employeeId))
                .stream().map(EmployeeJobRelation::getJobInfoId).collect(Collectors.toList());
        responseDTO.setJobInfoIds(collect);
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult editEmployee(EditEmployeeRequestDTO requestDTO) {
        Employee employee = this.getById(requestDTO.getId());
        if (employee == null) {
            ExceptionCast.cast("该员工不存在！");
        }
        int nameCount = this.count(Wrappers.<Employee>lambdaQuery().eq(Employee::getUnitInfoId, employee.getUnitInfoId()).eq(Employee::getEmployeeName, requestDTO.getEmployeeName()).ne(Employee::getId,employee.getId()));
        if (nameCount > 0) {
            ExceptionCast.cast("员工名称已存在！");
        }
        Employee updateEmployee = new Employee();
        BeanUtils.copyProperties(requestDTO,updateEmployee);
        this.updateById(updateEmployee);
        List<EmployeeJobRelation> list = new ArrayList<>();
        // 先删除用户之前的岗位
        employeeJobRelationService.remove(Wrappers.<EmployeeJobRelation>lambdaQuery().eq(EmployeeJobRelation::getEmployeeId,updateEmployee.getId()));
        for (Long jobInfoId : requestDTO.getJobInfoIds()) {
            list.add(new EmployeeJobRelation().setJobInfoId(jobInfoId).setEmployeeId(updateEmployee.getId()).setCreatedId(requestDTO.getCreatedId()));
        }
        // 再添加编辑后的岗位
        employeeJobRelationService.saveBatch(list);
        return ResponseResult.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult delEmployee(Long employeeId) {
        int count = this.count(Wrappers.<Employee>lambdaQuery().eq(Employee::getId, employeeId));
        if (count <= 0) {
            ExceptionCast.cast("该员工不存在！");
        }
        this.removeById(employeeId);
        employeeJobRelationService.remove(Wrappers.<EmployeeJobRelation>lambdaQuery().eq(EmployeeJobRelation::getEmployeeId,employeeId));
        return ResponseResult.SUCCESS();
    }

    @Override
    public CommonResponseResult<FindSchoolResourcesListResponseDTO> findSchoolResourcesByEmployeeId(Long employeeId) {
        FindSchoolResourcesListResponseDTO responseDTO = new FindSchoolResourcesListResponseDTO();
        List<SchoolSysResources> list = baseMapper.findSysResourcesByEmployeeId(employeeId);
        if (list.isEmpty()) {
            ExceptionCast.cast("该用户不存在，或已被删除！");
        }
        responseDTO.setSchoolSysResources(businessUtils.findChildList(null, list));
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public CommonResponseResult<SafeEmployeeLoginResponseDTO> safeEmployeeLogin(EmployeeLoginRequestDTO requestDTO) {
        Employee employee = this.getOne(Wrappers.<Employee>lambdaQuery().eq(Employee::getUserName, requestDTO.getUserName()));
        if (employee == null) {
            ExceptionCast.cast("账号不存在！");
        }
        if (!requestDTO.getPassWord().equalsIgnoreCase(employee.getPassWord())) {
            ExceptionCast.cast("账号或密码错误！");
        }
        SafeEmployeeLoginResponseDTO responseDTO = new SafeEmployeeLoginResponseDTO();
        BeanUtils.copyProperties(employee,responseDTO);
        UnitInfo unitInfo = unitInfoMapper.selectOne(Wrappers.<UnitInfo>lambdaQuery().select(UnitInfo::getUnitName,UnitInfo::getUnitType).eq(UnitInfo::getId, employee.getUnitInfoId()));
        if (unitInfo == null) {
            ExceptionCast.cast("该用户工作单位数据异常，请联系管理员！");
        }
        if (unitInfo.getUnitType() != 1) {
            ExceptionCast.cast("账号不存在！");
        }
        responseDTO.setUnitInfoName(unitInfo.getUnitName());
        return new CommonResponseResult<SafeEmployeeLoginResponseDTO>(responseDTO);
    }
}
