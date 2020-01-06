package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.safecampus.dal.dao.AppVersionMapper;
import com.jintu.safecampus.dal.model.AppVersion;
import com.jintu.safecampus.service.IAppVersionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app版本发布 app版本发布表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements IAppVersionService {

}
