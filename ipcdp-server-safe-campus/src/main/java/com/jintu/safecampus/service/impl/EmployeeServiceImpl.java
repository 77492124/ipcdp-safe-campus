package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import com.jintu.safecampus.dal.dao.EmployeeMapper;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.model.Employee;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        UnitInfo unitInfo = unitInfoMapper.selectOne(Wrappers.<UnitInfo>lambdaQuery().select(UnitInfo::getUnitName).eq(UnitInfo::getId, employee.getUnitInfoId()));
        if (unitInfo == null) {
            ExceptionCast.cast("该用户工作单位数据异常，请联系管理员！");
        }
        responseDTO.setUnitInfoName(unitInfo.getUnitName());
        return new CommonResponseResult<>(responseDTO);
    }
}
