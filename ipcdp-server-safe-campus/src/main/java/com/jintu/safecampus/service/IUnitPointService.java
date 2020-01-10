package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitPointRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitPointListResponseDTO;
import com.jintu.safecampus.dal.model.UnitPoint;

/**
 * <p>
 * 单位点位 单位点位信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IUnitPointService extends IService<UnitPoint> {
    /**
     * 查询单位点位列表
     * @param requestDTO 查询条件
     * @return 点位列表
     */
    QueryResponseResult<FindUnitPointListResponseDTO> findUnitPointList(FindUnitPointListRequestDTO requestDTO);
    /**
     * 添加单位点位
     * @param requestDTO 单位点位
     * @return 是否成功
     */
    ResponseResult saveUnitPoint(SaveUnitPointRequestDTO requestDTO);

    /**
     * 编辑单位点位
     * @param requestDTO 单位点位
     * @return 是否成功
     */
    ResponseResult editUnitPoint(EditUnitPointRequestDTO requestDTO);

    /**
     * 删除单位点位
     * @param unitPointId 单位点位Id
     * @return 是否成功
     */
    ResponseResult delUnitPoint(Long unitPointId);
}
