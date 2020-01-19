package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.dal.model.UnitInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 单位信息表 单位信息表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface UnitInfoMapper extends BaseMapper<UnitInfo> {

    /**
     * 查询单位列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return
     */
    IPage<FindUnitInfoListResponseDTO> findUnitInfoList(Page<FindUnitInfoListResponseDTO> page, @Param("dto") FindUnitInfoListRequestDTO requestDTO);

    /**
     * 根据单位id查询单位信息
     * @param id 单位id
     * @return 单位信息
     */
    EditUnitInfoResponseDTO findUnitInfoById(Long id);

    /**
     * 查询学校列表
     * @param unitName
     * @return
     */
    List<FindSchoolListResponseDTO> findSchoolList(@Param("unitName") String unitName);
}
