package com.jintu.ipcdp.framework.api.safecampus;

import com.jintu.ipcdp.framework.api.safecampus.fallback.UnitServerInfoControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author Parker
 * @Description: 单位服务器列表API
 * @Date 2020/1/7 11:43
 * @Version 1.0
 */
@FeignClient(name = JtServiceList.IPCDP_SERVER_SAFE_CAMPUS, path = "/safe-campus/unit-server-info/", fallback = UnitServerInfoControllerApiFallBack.class)
public interface UnitServerInfoControllerApi {


}
