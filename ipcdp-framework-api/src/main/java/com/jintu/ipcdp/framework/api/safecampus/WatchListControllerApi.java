package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.WatchListControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Parker
 * @Description: 值班表API
 * @Date 2020/1/13 17:15
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/watch-list/", fallback = WatchListControllerApiFallBack.class)
public interface WatchListControllerApi {
    /**
     * 查询值班列表
     * @param requestDTO 查询条件
     * @return 值班列表
     */
    @GetMapping("list")
    QueryResponseResult<FindWatchListResponseDTO> findWatchList(@Validated FindWatchListRequestDTO requestDTO);

    /**
     * 导出值班表
     * @param requestDTO 条件
     * @param response 返回
     */
    @GetMapping("exportWatchList")
    void exportWatchList(@Validated ExportWatchListRequestDTO requestDTO, HttpServletResponse response) throws Exception;
}
