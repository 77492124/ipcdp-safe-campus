package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
import com.jintu.safecampus.dal.model.NursingPostTime;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 护学岗时间 护学岗时间表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface NursingPostTimeMapper extends BaseMapper<NursingPostTime> {
    /**
     * 查询单位护学岗时间列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return  护学岗时间列表
     */
    IPage<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(Page<FindNursingPostTimeListResponseDTO> page, @Param("dto") FindNursingPostTimeListRequestDTO requestDTO);
}
