package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
import com.jintu.safecampus.dal.model.JobInfo;

/**
 * <p>
 * 岗位信息表 岗位信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IJobInfoService extends IService<JobInfo> {
    /**
     * 查询单位的岗位列表
     * @param requestDTO 查询条件
     * @return 岗位列表
     */
    QueryResponseResult<FindJobInfoListResponseDTO> findJobInfoList(FindJobInfoListRequestDTO requestDTO);
    /**
     * 根据id查询岗位信息
     * @param jobInfoId 岗位id
     * @return 岗位信息
     */
    CommonResponseResult<FindJobInfoByIdResponseDTO> findJobInfoById(Long jobInfoId);
    /**
     * 添加岗位
     * @param requestDTO 岗位信息
     * @return 是否成功
     */
    ResponseResult saveJobInfo(SaveJobInfoRequestDTO requestDTO);
    /**
     * 编辑岗位信息
     * @param requestDTO 岗位信息
     * @return 是否成功
     */
    ResponseResult editJobInfo(EditJobInfoRequestDTO requestDTO);
    /**
     * 根据岗位id删除岗位
     * @param jobInfoId 岗位id
     * @return 是否成功
     */
    ResponseResult delJobInfo(Long jobInfoId);
    /**
     * 岗位id查询资源权限id列表
     * @param jobInfoId 岗位id
     * @return 资源权限id列表
     */
    QueryResponseResult<FindJobResourcesIdsResponseDTO> findJobResourcesIds(Long jobInfoId);
    /**
     * 岗位授权
     * @param requestDTO 授权信息
     * @return 是否成功
     */
    ResponseResult jobAuthorize(JobAuthorizeRequestDTO requestDTO);
}
