package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.AppVersionControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindAppVersionListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveAppVersionRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindAppVersionListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: app版本发布API
 * @Date 2020/1/7 16:05
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/app-version/", fallback = AppVersionControllerApiFallBack.class)
public interface AppVersionControllerApi {
    /**
     * 查询App版本发布列表
     * @param requestDTO 查询条件
     * @return 发布列表
     */
    @GetMapping("list")
    QueryResponseResult<FindAppVersionListResponseDTO> findAppVersionList(@Validated FindAppVersionListRequestDTO requestDTO);

    /**
     * App版本发布
     * @param requestDTO 版本发布信息
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveAppVersion(@Validated @RequestBody SaveAppVersionRequestDTO requestDTO);
}
