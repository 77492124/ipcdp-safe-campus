package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.NursingPostTimeControllerApi;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.INursingPostTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 护学岗时间 护学岗时间表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "护学岗时间接口 ")
@RestController
@RequestMapping("/nursing-post-time")
public class NursingPostTimeController implements NursingPostTimeControllerApi {

    @Resource
    private INursingPostTimeService nursingPostTimeService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位护学岗时间列表")
    @ApiOperation(value = "查询单位护学岗时间列表", response = FindNursingPostTimeListResponseDTO.class)
    @Override
    public QueryResponseResult<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(FindNursingPostTimeListRequestDTO requestDTO) {
        return nursingPostTimeService.findNursingPostTimeList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加单位护学岗时间")
    @ApiOperation(value = "添加单位护学岗时间", response = ResponseResult.class)
    @Override
    public ResponseResult saveNursingPostTime(SaveNursingPostTimeRequestDTO requestDTO) {
        return nursingPostTimeService.saveNursingPostTime(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑单位护学岗时间")
    @ApiOperation(value = "编辑单位护学岗时间", response = ResponseResult.class)
    @Override
    public ResponseResult editNursingPostTime(EditNursingPostTimeRequestDTO requestDTO) {
        return nursingPostTimeService.editNursingPostTime(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据id删除单位护学岗时间")
    @ApiOperation(value = "根据id删除单位护学岗时间", response = ResponseResult.class)
    @Override
    public ResponseResult delNursingPostTime(Long nursingPostTimeId) {
        return nursingPostTimeService.delNursingPostTime(nursingPostTimeId);
    }
}
