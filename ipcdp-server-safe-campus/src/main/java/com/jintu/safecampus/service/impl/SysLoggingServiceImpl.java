package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.safecampus.dal.dao.SysLoggingMapper;
import com.jintu.safecampus.dal.model.SysLogging;
import com.jintu.safecampus.service.ISysLoggingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 系统操作日志表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class SysLoggingServiceImpl extends ServiceImpl<SysLoggingMapper, SysLogging> implements ISysLoggingService {

}
