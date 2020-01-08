package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.JobInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindJobInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.JobAuthorizeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobResourcesIdsResponseDTO;
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
 * @Description: 岗位信息API
 * @Date 2020/1/8 11:59
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/job-info/", fallback = JobInfoControllerApiFallBack.class)
public interface JobInfoControllerApi {

    /**
     * 查询单位的岗位列表
     * @param requestDTO 查询条件
     * @return 岗位列表
     */
    @GetMapping("list")
    QueryResponseResult<FindJobInfoListResponseDTO> findJobInfoList(@Validated FindJobInfoListRequestDTO requestDTO);

    /**
     * 根据id查询岗位信息
     * @param jobInfoId 岗位id
     * @return 岗位信息
     */
    @GetMapping("{jobInfoId}")
    CommonResponseResult<FindJobInfoByIdResponseDTO> findJobInfoById(@PathVariable("jobInfoId") Long jobInfoId);

    /**
     * 添加岗位
     * @param requestDTO 岗位信息
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveJobInfo(@Validated @RequestBody SaveJobInfoRequestDTO requestDTO);

    /**
     * 编辑岗位信息
     * @param requestDTO 岗位信息
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editJobInfo(@Validated @RequestBody EditJobInfoRequestDTO requestDTO);

    /**
     * 根据岗位id删除岗位
     * @param jobInfoId 岗位id
     * @return 是否成功
     */
    @DeleteMapping("{jobInfoId}")
    ResponseResult delJobInfo(@PathVariable("jobInfoId") Long jobInfoId);

    /**
     * 岗位id查询资源权限id列表
     * @param jobInfoId 岗位id
     * @return 资源权限id列表
     */
    @GetMapping("jobResourcesList/{jobInfoId}")
    QueryResponseResult<FindJobResourcesIdsResponseDTO> findJobResourcesIds(@PathVariable("jobInfoId") Long jobInfoId);

    /**
     * 岗位授权
     * @param requestDTO 授权信息
     * @return 是否成功
     */
    @PostMapping("jobAuthorize")
    ResponseResult jobAuthorize(@Validated @RequestBody JobAuthorizeRequestDTO requestDTO);
}
