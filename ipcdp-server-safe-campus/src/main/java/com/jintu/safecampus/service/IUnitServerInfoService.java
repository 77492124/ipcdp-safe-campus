package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitPointListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitServerInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitServerInfoListResponseDTO;
import com.jintu.safecampus.dal.model.UnitServerInfo;

/**
 * <p>
 * 单位服务器列表 单位服务器列表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IUnitServerInfoService extends IService<UnitServerInfo> {
    /**
     * 查询单位服务器列表
     * @param requestDTO
     * @return
     */
    QueryResponseResult<FindUnitServerInfoListResponseDTO> findUnitServerInfoList(FindUnitPointListRequestDTO requestDTO);

    /**
     * 增加单位服务器
     * @param requestDTO
     * @return
     */
    ResponseResult saveUnitServerInfoList(SaveUnitServerInfoRequestDTO requestDTO);

    /**
     * 修改单位服务器
     * @param requestDTO
     * @return
     */
    ResponseResult editUnitServerInfo(EditUnitServerInfoRequestDTO requestDTO);

    /**
     * 删除单位服务器
     * @param unitSserverInfoId 单位服务器id
     * @return
     */
    ResponseResult delUnitServerInfo(Long unitSserverInfoId);
}
