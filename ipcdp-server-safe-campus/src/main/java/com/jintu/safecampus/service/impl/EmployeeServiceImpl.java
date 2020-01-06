package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.safecampus.dal.dao.EmployeeMapper;
import com.jintu.safecampus.dal.model.Employee;
import com.jintu.safecampus.service.IEmployeeService;
import org.springframework.stereotype.Service;

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

}
