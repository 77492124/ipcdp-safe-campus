package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.NursingPostPersonControllerApiFallBack;
import com.jintu.ipcdp.framework.api.safecampus.fallback.NursingPostPersonWorkRecordControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.NursingPostWorkRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Classname
 * @Description 护学岗人员上班记录Api
 * @Date 2020/1/17 9:24
 * @Created by lyx
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/nursing-post-person-work/", fallback = NursingPostPersonWorkRecordControllerApiFallBack.class)
public interface NursingPostPersonWorkRecordControllerApi {
    /**
     * 护学岗APP上下班
     * @return
     */
    @PostMapping("nursingPostWork")
    ResponseResult nursingPostWork(@Validated @RequestBody NursingPostWorkRequestDTO nursingPostWorkRequestDTO);
}
