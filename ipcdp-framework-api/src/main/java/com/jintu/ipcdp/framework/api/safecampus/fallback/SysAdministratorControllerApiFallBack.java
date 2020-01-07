package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.SysAdministratorControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.AdministratorLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.AdministratorLoginResponseDTO;
import org.springframework.stereotype.Component;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/6 15:21
 * @Version 1.0
 */
@Component
public class SysAdministratorControllerApiFallBack implements SysAdministratorControllerApi {
    @Override
    public CommonResponseResult<AdministratorLoginResponseDTO> administratorLogin(AdministratorLoginRequestDTO requestDTO) {
        return new CommonResponseResult<>(CommonCode.SERVER_ANOMALY);
    }
}
