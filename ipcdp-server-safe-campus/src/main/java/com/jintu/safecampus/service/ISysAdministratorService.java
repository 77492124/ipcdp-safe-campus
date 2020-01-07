package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.AdministratorLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.AdministratorLoginResponseDTO;
import com.jintu.safecampus.dal.model.SysAdministrator;

/**
 * <p>
 * 系统管理员表 系统管理员表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface ISysAdministratorService extends IService<SysAdministrator> {
    /**
     * 超级管理员登录
     * @param requestDTO 登录信息
     * @return 管理员信息
     */
    CommonResponseResult<AdministratorLoginResponseDTO> administratorLogin(AdministratorLoginRequestDTO requestDTO);
}
