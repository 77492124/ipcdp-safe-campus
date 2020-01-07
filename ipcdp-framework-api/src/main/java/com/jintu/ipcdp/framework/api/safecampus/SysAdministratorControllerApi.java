package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.SysAdministratorControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.AdministratorLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.AdministratorLoginResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 15:18
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/sys-administrator/", fallback = SysAdministratorControllerApiFallBack.class)
public interface SysAdministratorControllerApi {
    /**
     * 超级管理员登录
     * @param requestDTO 登录信息
     * @return 管理员信息
     */
    @PostMapping("login")
    CommonResponseResult<AdministratorLoginResponseDTO> administratorLogin(@Validated @RequestBody AdministratorLoginRequestDTO requestDTO);


}
