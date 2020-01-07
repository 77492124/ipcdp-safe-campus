package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.dal.dao.UnitInfoMapper;
import com.jintu.safecampus.dal.model.UnitInfo;
import com.jintu.safecampus.service.IUnitInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单位信息表 单位信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class UnitInfoServiceImpl extends ServiceImpl<UnitInfoMapper, UnitInfo> implements IUnitInfoService {

    @Override
    public QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO) {
        Page<FindUnitInfoListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        IPage<FindUnitInfoListResponseDTO> iPage = baseMapper.findUnitInfoList(page,requestDTO);
        QueryResult<FindUnitInfoListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }
}
