package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.NursingPostPersonControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonLoginResponseDTO;
import com.jintu.safecampus.common.annotation.MyLog;
import com.jintu.safecampus.common.enums.ActionTypeEnum;
import com.jintu.safecampus.service.INursingPostPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 护学岗人员 护学岗人员表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "护学岗人员接口 ")
@RestController
@RequestMapping("/nursing-post-person")
public class NursingPostPersonController implements NursingPostPersonControllerApi {

    @Resource
    private INursingPostPersonService nursingPostPersonService;

    @MyLog(actionType = ActionTypeEnum.FIND, description = "查询单位护学岗人员列表")
    @ApiOperation(value = "查询单位护学岗人员列表", response = FindNursingPostPersonListResponseDTO.class)
    @Override
    public QueryResponseResult<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(FindNursingPostPersonListRequestDTO requestDTO) {
        return nursingPostPersonService.findNursingPostPersonList(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.SAVE, description = "添加护学岗人员")
    @ApiOperation(value = "添加护学岗人员", response = ResponseResult.class)
    @Override
    public ResponseResult saveNursingPostPerson(SaveNursingPostPersonRequestDTO requestDTO) {
        return nursingPostPersonService.saveNursingPostPerson(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.UPDATE, description = "编辑护学岗人员")
    @ApiOperation(value = "编辑护学岗人员", response = ResponseResult.class)
    @Override
    public ResponseResult editNursingPostPerson(EditNursingPostPersonRequestDTO requestDTO) {
        return nursingPostPersonService.editNursingPostPerson(requestDTO);
    }

    @MyLog(actionType = ActionTypeEnum.DELETE, description = "根据id删除护学岗人员")
    @ApiOperation(value = "根据id删除护学岗人员", response = ResponseResult.class)
    @Override
    public ResponseResult delNursingPostPerson(Long nursingPostPersonId) {
        return nursingPostPersonService.delNursingPostPerson(nursingPostPersonId);
    }

    @MyLog(actionType = ActionTypeEnum.FIND, description = "护学岗人员APP登录")
    @ApiOperation(value = "护学岗人员APP登录", response = NursingPostPersonLoginResponseDTO.class)
    @Override
    public CommonResponseResult<NursingPostPersonLoginResponseDTO> nursingPostPersonLogin(NursingPostPersonLoginRequestDTO requestDTO) {
        return nursingPostPersonService.nursingPostPersonLogin(requestDTO);
    }
}
