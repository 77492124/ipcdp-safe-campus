package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.safecampus.dal.dao.AlarmInfoMapper;
import com.jintu.safecampus.dal.model.AlarmInfo;
import com.jintu.safecampus.service.IAlarmInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 告警表 告警信息表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class AlarmInfoServiceImpl extends ServiceImpl<AlarmInfoMapper, AlarmInfo> implements IAlarmInfoService {

}
