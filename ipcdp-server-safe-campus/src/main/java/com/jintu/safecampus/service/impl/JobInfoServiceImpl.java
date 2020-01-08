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
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindJobInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.JobAuthorizeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveJobInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobInfoListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindJobResourcesIdsResponseDTO;
import com.jintu.safecampus.dal.dao.EmployeeJobRelationMapper;
import com.jintu.safecampus.dal.dao.JobInfoMapper;
import com.jintu.safecampus.dal.model.EmployeeJobRelation;
import com.jintu.safecampus.dal.model.JobInfo;
import com.jintu.safecampus.dal.model.SchoolJobResources;
import com.jintu.safecampus.service.IJobInfoService;
import com.jintu.safecampus.service.ISchoolJobResourcesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 岗位信息表 岗位信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements IJobInfoService {


    @Resource
    private EmployeeJobRelationMapper employeeJobRelationMapper;

    @Resource
    private ISchoolJobResourcesService schoolJobResourcesService;

    @Override
    public QueryResponseResult<FindJobInfoListResponseDTO> findJobInfoList(FindJobInfoListRequestDTO requestDTO) {
        Page<FindJobInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindJobInfoListResponseDTO> iPage = baseMapper.findJobInfoList(page,requestDTO);
        QueryResult<FindJobInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public CommonResponseResult<FindJobInfoByIdResponseDTO> findJobInfoById(Long jobInfoId) {
        JobInfo jobInfo = this.getOne(Wrappers.<JobInfo>lambdaQuery().select(JobInfo::getId, JobInfo::getUnitInfoId, JobInfo::getJobName, JobInfo::getJobDescription));
        if (jobInfo == null) {
            ExceptionCast.cast("该岗位不存在！");
        }
        FindJobInfoByIdResponseDTO responseDTO = new FindJobInfoByIdResponseDTO();
        BeanUtils.copyProperties(jobInfo,responseDTO);
        return new CommonResponseResult<>(responseDTO);
    }

    @Override
    public ResponseResult saveJobInfo(SaveJobInfoRequestDTO requestDTO) {
        int count = this.count(Wrappers.<JobInfo>lambdaQuery().eq(JobInfo::getUnitInfoId, requestDTO.getUnitInfoId()).eq(JobInfo::getJobName, requestDTO.getJobName()));
        if (count > 0) {
            ExceptionCast.cast("岗位名称不能重复！");
        }
        JobInfo jobInfo = new JobInfo();
        BeanUtils.copyProperties(requestDTO,jobInfo);
        this.save(jobInfo);
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editJobInfo(EditJobInfoRequestDTO requestDTO) {
        int count = this.count(Wrappers.<JobInfo>lambdaQuery().eq(JobInfo::getId, requestDTO.getId()).eq(JobInfo::getUnitInfoId,requestDTO.getUnitInfoId()));
        if (count <= 0) {
            ExceptionCast.cast("编辑岗位不存在！");
        }
        int jobNameCount = this.count(Wrappers.<JobInfo>lambdaQuery().eq(JobInfo::getUnitInfoId,requestDTO.getUnitInfoId()).eq(JobInfo::getJobName,requestDTO.getJobName()).ne(JobInfo::getId, requestDTO.getId()));
        if (jobNameCount > 0) {
            ExceptionCast.cast("岗位名称不能重复！");
        }
        JobInfo jobInfo = new JobInfo();
        BeanUtils.copyProperties(requestDTO,jobInfo);
        this.save(jobInfo);
        return ResponseResult.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult delJobInfo(Long jobInfoId) {
        int count = this.count(Wrappers.<JobInfo>lambdaQuery().eq(JobInfo::getId, jobInfoId));
        if (count <= 0) {
            ExceptionCast.cast("删除岗位不存在！");
        }
        int employeeJobCount = employeeJobRelationMapper.selectCount(Wrappers.<EmployeeJobRelation>lambdaQuery().eq(EmployeeJobRelation::getJobInfoId, jobInfoId));
        if (employeeJobCount > 0){
            ExceptionCast.cast("请先删除该岗位下的员工！");
        }
        this.removeById(jobInfoId);
        schoolJobResourcesService.remove(Wrappers.<SchoolJobResources>lambdaQuery().eq(SchoolJobResources::getJobInfoId,jobInfoId));
        return ResponseResult.SUCCESS();
    }

    @Override
    public QueryResponseResult<FindJobResourcesIdsResponseDTO> findJobResourcesIds(Long jobInfoId) {
        List<FindJobResourcesIdsResponseDTO> collect = schoolJobResourcesService.list(Wrappers.<SchoolJobResources>lambdaQuery()
                .select(SchoolJobResources::getSchoolSysResourcesId).eq(SchoolJobResources::getJobInfoId, jobInfoId))
                .stream().map(s -> new FindJobResourcesIdsResponseDTO().setSchoolSysResourcesId(s.getSchoolSysResourcesId())).collect(Collectors.toList());
        QueryResult<FindJobResourcesIdsResponseDTO> queryResult = new QueryResult<>(collect, (long) collect.size());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult jobAuthorize(JobAuthorizeRequestDTO requestDTO) {
        int count = this.count(Wrappers.<JobInfo>lambdaQuery().eq(JobInfo::getId, requestDTO.getId()));
        if (count <= 0) {
            ExceptionCast.cast("授权岗位不存在！");
        }
        schoolJobResourcesService.remove(Wrappers.<SchoolJobResources>lambdaQuery().eq(SchoolJobResources::getJobInfoId,requestDTO.getId()));
        List<SchoolJobResources> schoolJobResourcesList = new ArrayList<>();
        for (Long schoolSysResourcesId : requestDTO.getSchoolSysResourcesIds()) {
            schoolJobResourcesList.add(new SchoolJobResources()
                    .setJobInfoId(requestDTO.getId())
                    .setSchoolSysResourcesId(schoolSysResourcesId)
                    .setCreatedId(requestDTO.getCreatedId()));
        }
        schoolJobResourcesService.saveBatch(schoolJobResourcesList);
        return ResponseResult.SUCCESS();
    }
}
