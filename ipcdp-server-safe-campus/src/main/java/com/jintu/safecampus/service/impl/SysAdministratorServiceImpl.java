package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.AdministratorLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.AdministratorLoginResponseDTO;
import com.jintu.safecampus.dal.dao.SysAdministratorMapper;
import com.jintu.safecampus.dal.model.SysAdministrator;
import com.jintu.safecampus.service.ISysAdministratorService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 系统管理员表 系统管理员表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class SysAdministratorServiceImpl extends ServiceImpl<SysAdministratorMapper, SysAdministrator> implements ISysAdministratorService {

    @Override
    public CommonResponseResult<AdministratorLoginResponseDTO> administratorLogin(AdministratorLoginRequestDTO requestDTO) {
        SysAdministrator sysAdministrator = this.getOne(Wrappers.<SysAdministrator>lambdaQuery().eq(SysAdministrator::getUserName, requestDTO.getUserName()));
        if (sysAdministrator == null) {
            ExceptionCast.cast("该账号不存在！");
        }
        String md5Hex = DigestUtils.md5Hex(requestDTO.getPassWord());
        if (!StringUtils.equals(md5Hex,sysAdministrator.getPassWord())) {
            ExceptionCast.cast("密码错误！");
        }
        AdministratorLoginResponseDTO responseDTO = new AdministratorLoginResponseDTO();
        BeanUtils.copyProperties(sysAdministrator,responseDTO);
        return new CommonResponseResult<>(responseDTO);
    }
}
