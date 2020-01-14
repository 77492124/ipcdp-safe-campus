package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.safecampus.dal.model.UnitCameraList;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 单位摄像头列表 单位摄像头列表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface UnitCameraListMapper extends BaseMapper<UnitCameraList> {

    IPage<FindUnitCameraListResponseDTO> findUnitCameraList(Page<FindUnitCameraListResponseDTO> page,@Param("requestDTO") FindUnitPointListRequestDTO requestDTO);
}
