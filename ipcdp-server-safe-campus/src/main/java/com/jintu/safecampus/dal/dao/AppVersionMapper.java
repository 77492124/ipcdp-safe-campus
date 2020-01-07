package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import com.jintu.safecampus.dal.model.AppVersion;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * app版本发布 app版本发布表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface AppVersionMapper extends BaseMapper<AppVersion> {
    /**
     * 查询App版本发布列表
     * @param page 分页
     * @param requestDTO 条件
     * @return 列表
     */
    IPage<FindAppVersionListResponseDTO> findAppVersionList(Page<FindAppVersionListResponseDTO> page,@Param("dto") FindAppVersionListRequestDTO requestDTO);
}
