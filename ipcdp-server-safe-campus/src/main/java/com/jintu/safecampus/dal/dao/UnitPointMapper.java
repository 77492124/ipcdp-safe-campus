package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.dal.model.UnitPoint;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 单位点位 单位点位信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface UnitPointMapper extends BaseMapper<UnitPoint> {

    /**
     * 查询单位点位列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return 点位列表
     */
    IPage<FindUnitPointListResponseDTO> findUnitPointList(Page<FindUnitPointListResponseDTO> page, @Param("dto") FindUnitPointListRequestDTO requestDTO);
}
