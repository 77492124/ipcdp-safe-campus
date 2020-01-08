package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindJobInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoListResponseDTO;
import com.jintu.safecampus.dal.model.JobInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 岗位信息表 岗位信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface JobInfoMapper extends BaseMapper<JobInfo> {
    /**
     * 查询单位的岗位列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return 列表
     */
    IPage<FindJobInfoListResponseDTO> findJobInfoList(Page<FindJobInfoListResponseDTO> page, @Param("dto") FindJobInfoListRequestDTO requestDTO);
}
