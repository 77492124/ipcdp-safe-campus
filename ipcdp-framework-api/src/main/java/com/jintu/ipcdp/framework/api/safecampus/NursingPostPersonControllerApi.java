package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.NursingPostPersonControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonLoginResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 护学岗人员API
 * @Date 2020/1/10 15:25
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/nursing-post-person/", fallback = NursingPostPersonControllerApiFallBack.class)
public interface NursingPostPersonControllerApi {

    /**
     * 查询单位护学岗人员列表
     * @param requestDTO 查询条件
     * @return 护学岗人员列表
     */
    @GetMapping("list")
    QueryResponseResult<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(@Validated FindNursingPostPersonListRequestDTO requestDTO);

    /**
     * 添加护学岗人员
     * @param requestDTO 护学岗人员
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveNursingPostPerson(@Validated @RequestBody SaveNursingPostPersonRequestDTO requestDTO);

    /**
     * 编辑护学岗人员
     * @param requestDTO 护学岗人员
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editNursingPostPerson(@Validated @RequestBody EditNursingPostPersonRequestDTO requestDTO);

    /**
     * 根据id删除护学岗人员
     * @param nursingPostPersonId 护学岗人员ID
     * @return 是否成功
     */
    @DeleteMapping("{nursingPostPersonId}")
    ResponseResult delNursingPostPerson(@PathVariable("nursingPostPersonId") Long nursingPostPersonId);

    /**
     * 护学岗登录
     * @param requestDTO
     * @return
     */
    @PostMapping("nursingPostPersonLogin")
    CommonResponseResult<NursingPostPersonLoginResponseDTO> nursingPostPersonLogin(@Validated @RequestBody NursingPostPersonLoginRequestDTO requestDTO);
}
