package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitCameraListResponseDTO;
import com.jintu.safecampus.dal.model.UnitCameraList;

/**
 * <p>
 * 单位摄像头列表 单位摄像头列表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IUnitCameraListService extends IService<UnitCameraList> {

    QueryResponseResult<FindUnitCameraListResponseDTO> findUnitCameraList(FindUnitPointListRequestDTO requestDTO);
}
