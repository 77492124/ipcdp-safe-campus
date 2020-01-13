package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.PointRequirementsSettingApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditPointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SavePointRequirementsSettingRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindPointSettingListResponseDTO;
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
 * @Description: 点位需求设置API
 * @Date 2020/1/13 9:01
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/point-requirements-setting/", fallback = PointRequirementsSettingApiFallBack.class)
public interface PointRequirementsSettingControllerApi {

    /**
     * 根据护学岗时间id查询人员配置列表
     * @param nursingPostTimeId 护学岗时间id
     * @return 人员配置列表
     */
    @GetMapping("{nursingPostTimeId}")
    QueryResponseResult<FindPointSettingListResponseDTO> findPointRequirementsSettingList(@PathVariable("nursingPostTimeId") Long nursingPostTimeId);

    /**
     * 添加时间点位人员配置
     * @param requestDTO 人员配置
     * @return 是否成功
     */
    @PostMapping
    ResponseResult savePointRequirementsSetting(@Validated @RequestBody SavePointRequirementsSettingRequestDTO requestDTO);

    /**
     * 编辑时间点位人员配置
     * @param requestDTO 人员配置
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editPointRequirementsSetting(@Validated @RequestBody EditPointRequirementsSettingRequestDTO requestDTO);

    /**
     * 根据id删除时间点位人员配置
     * @param id id
     * @return 是否成功
     */
    @DeleteMapping("{id}")
    ResponseResult delPointRequirementsSetting(@PathVariable("id") Long id);
}
