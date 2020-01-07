package com.jintu.safecampus.controller;


import com.jintu.ipcdp.framework.api.safecampus.UnitServerInfoControllerApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 单位服务器列表 单位服务器列表 前端控制器
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Api(tags = "单位服务器列表接口")
@RestController
@RequestMapping("/unit-server-info")
public class UnitServerInfoController implements UnitServerInfoControllerApi {

}
