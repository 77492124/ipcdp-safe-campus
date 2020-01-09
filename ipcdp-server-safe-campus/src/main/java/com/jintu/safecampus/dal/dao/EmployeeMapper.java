package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeListResponseDTO;
import com.jintu.safecampus.dal.model.Employee;
import com.jintu.safecampus.dal.model.SchoolSysResources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工表 员工信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 根据员工id查询员工所属岗位的权限列表
     * @param employeeId 员工id
     * @return 权限列表
     */
    List<SchoolSysResources> findSysResourcesByEmployeeId(Long employeeId);

    /**
     * 查询员工列表
     * @param page 分页信息
     * @param requestDTO 查询条件
     * @return 员工列表
     */
    IPage<FindEmployeeListResponseDTO> findEmployeeList(Page<FindEmployeeListResponseDTO> page, @Param("dto") FindEmployeeListRequestDTO requestDTO);
}
