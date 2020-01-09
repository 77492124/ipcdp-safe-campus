package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.EmployeeControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.EmployeeLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindEmployeeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveEmployeeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.EmployeeLoginResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindEmployeeListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolResourcesListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 员工信息API
 * @Date 2020/1/8 11:35
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/employee/", fallback = EmployeeControllerApiFallBack.class)
public interface EmployeeControllerApi {

    /**
     * 学校员工登录
     * @param requestDTO 登录信息
     * @return 员工信息
     */
    @PostMapping("employeeLogin")
    CommonResponseResult<EmployeeLoginResponseDTO> employeeLogin(@Validated @RequestBody EmployeeLoginRequestDTO requestDTO);

    /**
     * 查询学校员工列表
     * @param requestDTO 查询条件
     * @return 员工列表
     */
    @GetMapping("list")
    QueryResponseResult<FindEmployeeListResponseDTO> findEmployeeList(@Validated FindEmployeeListRequestDTO requestDTO);

    /**
     * 新增员工
     * @param requestDTO 员工信息
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveEmployee(@Validated @RequestBody SaveEmployeeRequestDTO requestDTO);

    /**
     * 根据id查询学校员工详情
     * @param employeeId 员工id
     * @return 员工详情
     */
    @GetMapping("{employeeId}")
    CommonResponseResult<FindEmployeeByIdResponseDTO> findEmployeeById(@PathVariable("employeeId") Long employeeId);

    /**
     * 编辑学校员工
     * @param requestDTO 员工信息
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editEmployee(@Validated @RequestBody EditEmployeeRequestDTO requestDTO);

    /**
     * 删除学校员工
     * @param employeeId 员工id
     * @return 是否成功
     */
    @DeleteMapping("{employeeId}")
    ResponseResult delEmployee(@PathVariable("employeeId") Long employeeId);

    /**
     * 查询学校员工的权限树
     * @param employeeId 员工id
     * @return 权限树
     */
    @GetMapping("findSchoolResources/{employeeId}")
    CommonResponseResult<FindSchoolResourcesListResponseDTO> findSchoolResourcesByEmployeeId(@PathVariable("employeeId") Long employeeId);

    



}
