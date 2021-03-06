package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.PointRequirementsPersonnelApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindShiftSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveShiftSettingBaseRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingBaseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 排班设置接口PAI
 * @Date 2020/1/13 10:27
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/point-requirements-personnel/", fallback = PointRequirementsPersonnelApiFallBack.class)
public interface PointRequirementsPersonnelControllerApi {

    /**
     * 根据护学岗时间id查询排班列表
     * @param requestDTO 护学岗时间id
     * @return  排班列表
     */
    @GetMapping("findShiftSetting")
    CommonResponseResult<FindShiftSettingBaseResponseDTO> findShiftSetting(@Validated FindShiftSettingRequestDTO requestDTO);

    /**
     * 保存排班设置
     * @param requestDTO 排班信息
     * @return 是否成功
     */
    @PostMapping("saveShiftSetting")
    ResponseResult saveShiftSetting(@Validated @RequestBody SaveShiftSettingBaseRequestDTO requestDTO);



}
