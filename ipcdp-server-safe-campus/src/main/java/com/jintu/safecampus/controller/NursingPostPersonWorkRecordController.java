package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.NursingPostPersonWorkRecordControllerApi;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.INursingPostPersonWorkRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 护学岗人员上班记录  前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
@Api(tags = "护学岗人员上班记录")
@RestController
@RequestMapping("/nursing-post-person-work-record")
public class NursingPostPersonWorkRecordController implements NursingPostPersonWorkRecordControllerApi {

    @Resource
    private INursingPostPersonWorkRecordService nursingPostPersonWorkRecordService;

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "护学岗APP上下班")
    @ApiOperation(value = "护学岗APP上下班", response = ResponseResult.class)
    @Override
    public ResponseResult nursingPostWork(NursingPostWorkRequestDTO nursingPostWorkRequestDTO) {
        return nursingPostPersonWorkRecordService.nursingPostWork(nursingPostWorkRequestDTO);
    }

}
