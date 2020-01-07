package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveAppVersionRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import com.jintu.safecampus.dal.model.AppVersion;

/**
 * <p>
 * app版本发布 app版本发布表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IAppVersionService extends IService<AppVersion> {
    /**
     * 查询App版本发布列表
     * @param requestDTO 查询条件
     * @return 发布列表
     */
    QueryResponseResult<FindAppVersionListResponseDTO> findAppVersionList(FindAppVersionListRequestDTO requestDTO);
    /**
     * App版本发布
     * @param requestDTO 版本发布信息
     * @return 是否成功
     */
    ResponseResult saveAppVersion(SaveAppVersionRequestDTO requestDTO);
}
