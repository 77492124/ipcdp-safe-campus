package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindDataRangeByEmployeeIdResponseDTO;
import com.jintu.safecampus.dal.model.EmployeeDataRange;

/**
 * <p>
 * 员工数据范围 员工数据范围 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IEmployeeDataRangeService extends IService<EmployeeDataRange> {
    /**
     * 根据员工id查询数据范围
     * @param employeeId 员工id
     * @return 数据范围
     */
    CommonResponseResult<FindDataRangeByEmployeeIdResponseDTO> findDataRangeByEmployeeId(Long employeeId);
}
