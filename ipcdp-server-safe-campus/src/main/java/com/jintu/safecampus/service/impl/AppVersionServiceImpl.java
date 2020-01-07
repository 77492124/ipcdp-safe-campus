package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveAppVersionRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import com.jintu.safecampus.dal.dao.AppVersionMapper;
import com.jintu.safecampus.dal.model.AppVersion;
import com.jintu.safecampus.service.IAppVersionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app版本发布 app版本发布表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements IAppVersionService {

    @Override
    public QueryResponseResult<FindAppVersionListResponseDTO> findAppVersionList(FindAppVersionListRequestDTO requestDTO) {
        Page<FindAppVersionListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        page.addOrder(OrderItem.desc("a.created_time"));
        IPage<FindAppVersionListResponseDTO> iPage = baseMapper.findAppVersionList(page,requestDTO);
        QueryResult<FindAppVersionListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveAppVersion(SaveAppVersionRequestDTO requestDTO) {
        int count = this.count(Wrappers.<AppVersion>lambdaQuery().eq(AppVersion::getVersionNumber, requestDTO.getVersionNumber()));
        if (count > 0) {
            ExceptionCast.cast("版本号不能重复！");
        }
        AppVersion appVersion = new AppVersion();
        BeanUtils.copyProperties(requestDTO,appVersion);
        this.save(appVersion);
        return ResponseResult.SUCCESS();
    }
}
