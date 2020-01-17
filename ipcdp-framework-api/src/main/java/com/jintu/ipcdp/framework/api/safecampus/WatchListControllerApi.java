package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.WatchListControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWorkInRealTimeStaffListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostTaskRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListByIdResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWorkInRealTimeStaffResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostTaskResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * @throws Exception 异常
     */
    @GetMapping("exportWatchList")
    void exportWatchList(@Validated ExportWatchListRequestDTO requestDTO, HttpServletResponse response) throws Exception;

    /**
     * 编辑值班列表
     * @param requestDTO 值班信息
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editWatchList(@Validated @RequestBody EditWatchListRequestDTO requestDTO);

    /**
     * 根据值班id查询编辑详情
     * @param watchListId 值班id
     * @return 详情
     */
    @GetMapping("{watchListId}")
    CommonResponseResult<FindWatchListByIdResponseDTO> findWatchListById(@PathVariable("watchListId") Long watchListId);

    /**
     * 护学岗管理展现页
     * @param requestDTO 查询条件
     * @return 展示数据
     */
    @GetMapping("findWorkInRealTimeStaffList")
    CommonResponseResult<FindWorkInRealTimeStaffResponseDTO> findWorkInRealTimeStaffList(@Validated FindWorkInRealTimeStaffListRequestDTO requestDTO);

    /**
     * 护学岗APP任务查询
     * @param requestDTO
     * @return
     */
    @PostMapping("findNursingPostTask")
    QueryResponseResult<NursingPostTaskResponseDTO> findNursingPostTask(@Validated @RequestBody NursingPostTaskRequestDTO requestDTO);

    /**
     * 根据值班id删除值班
     * @param watchListId 值班id
     * @return 是否成功
     */
    @DeleteMapping("{watchListId}")
    ResponseResult delWatchList(@PathVariable("watchListId") Long watchListId);
}
