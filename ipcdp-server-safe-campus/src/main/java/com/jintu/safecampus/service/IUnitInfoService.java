package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.dal.model.UnitInfo;

/**
 * <p>
 * 单位信息表 单位信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IUnitInfoService extends IService<UnitInfo> {
    /**
     * 查询单位信息列表
     * @param requestDTO 查询信息
     * @return 列表
     */
    QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO);
}
