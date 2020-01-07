package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindSysLoggingListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSysLoggingListResponseDTO;
import com.jintu.safecampus.dal.dao.SysLoggingMapper;
import com.jintu.safecampus.dal.model.SysLogging;
import com.jintu.safecampus.service.ISysLoggingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 系统操作日志表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class SysLoggingServiceImpl extends ServiceImpl<SysLoggingMapper, SysLogging> implements ISysLoggingService {

    @Override
    public QueryResponseResult<FindSysLoggingListResponseDTO> findSysLoggingList(FindSysLoggingListRequestDTO requestDTO) {
        Page<FindSysLoggingListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindSysLoggingListResponseDTO> iPage = baseMapper.findSysLoggingList(page,requestDTO);
        QueryResult<FindSysLoggingListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }
}
