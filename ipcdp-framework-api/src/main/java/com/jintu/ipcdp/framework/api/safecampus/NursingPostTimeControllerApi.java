package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.NursingPostTimeControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
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
 * @Description: 护学岗时间API
 * @Date 2020/1/10 16:46
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/nursing-post-time/", fallback = NursingPostTimeControllerApiFallBack.class)
public interface NursingPostTimeControllerApi {

    /**
     * 查询单位护学岗时间列表
     * @param requestDTO 查询条件
     * @return  护学岗时间列表
     */
    @GetMapping("list")
    QueryResponseResult<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(@Validated @RequestBody FindNursingPostTimeListRequestDTO requestDTO);

    /**
     * 添加单位护学岗时间
     * @param requestDTO 护学岗时间
     * @return 是否成功
     */
    @PostMapping
    ResponseResult saveNursingPostTime(@Validated @RequestBody SaveNursingPostTimeRequestDTO requestDTO);

    /**
     * 编辑单位护学岗时间
     * @param requestDTO 护学岗时间
     * @return 是否成功
     */
    @PutMapping
    ResponseResult editNursingPostTime(@Validated @RequestBody EditNursingPostTimeRequestDTO requestDTO);

    /**
     * 根据id删除单位护学岗时间
     * @param nursingPostTimeId 单位护学岗时间Id
     * @return 是否成功
     */
    @DeleteMapping("{nursingPostTimeId}")
    ResponseResult delNursingPostTime(@PathVariable("nursingPostTimeId") Long nursingPostTimeId);


}
