package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.WatchListControllerApi;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWorkInRealTimeStaffListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostTaskRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.*;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.IWatchListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Cleanup;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * <p>
 * 值班表 值班表信息 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "值班表接口")
@RestController
@RequestMapping("/watch-list")
public class WatchListController implements WatchListControllerApi {

    @Resource
    private IWatchListService watchListService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询值班列表")
    @ApiOperation(value = "查询值班列表", response = FindWatchListResponseDTO.class)
    @Override
    public QueryResponseResult<FindWatchListResponseDTO> findWatchList(FindWatchListRequestDTO requestDTO) {
        return watchListService.findWatchList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.OTHER, description = "导出值班表")
    @ApiOperation(value = "导出值班表")
    @Override
    public void exportWatchList(ExportWatchListRequestDTO requestDTO, HttpServletResponse response) throws Exception{
        Workbook workbook = watchListService.exportWatchList(requestDTO);
        if (workbook == null){
            ExceptionCast.cast("生成表格错误！");
        }
        @Cleanup OutputStream outputStream = response.getOutputStream();
        String name = String.format("attachment;fileName=%s%s", System.currentTimeMillis(), ".xlsx");
        // 配置文件下载
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", name);
        workbook.write(outputStream);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑值班列表")
    @ApiOperation(value = "编辑值班列表", response = ResponseResult.class)
    @Override
    public ResponseResult editWatchList(EditWatchListRequestDTO requestDTO) {
        return watchListService.editWatchList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "根据值班id查询编辑详情")
    @ApiOperation(value = "根据值班id查询编辑详情", response = FindWatchListByIdResponseDTO.class)
    @Override
    public CommonResponseResult<FindWatchListByIdResponseDTO> findWatchListById(Long watchListId) {
        return watchListService.findWatchListById(watchListId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "护学岗管理展现页")
    @ApiOperation(value = "护学岗管理展现页", response = FindWorkInRealTimeStaffResponseDTO.class)
    @Override
    public CommonResponseResult<FindWorkInRealTimeStaffResponseDTO> findWorkInRealTimeStaffList(FindWorkInRealTimeStaffListRequestDTO requestDTO) {
        return watchListService.findWorkInRealTimeStaffList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "护学岗APP任务查询")
    @ApiOperation(value = "护学岗APP任务查询", response = NursingPostTaskResponseDTO.class)
    @Override
    public QueryResponseResult<NursingPostTaskResponseDTO> findNursingPostTask(NursingPostTaskRequestDTO requestDTO) {
        return watchListService.findNursingPostTask(requestDTO);
    }


    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据值班id删除值班")
    @ApiOperation(value = "根据值班id删除值班", response = ResponseResult.class)
    @Override
    public ResponseResult delWatchList(Long watchListId) {
        return watchListService.delWatchList(watchListId);
    }


}
