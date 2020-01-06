package com.jintu.demo.controller;

import com.jintu.demo.service.StandardService;
import com.jintu.ipcdp.framework.api.datadictionary.StandardApi;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 文婧瑶
 * @Description: 标准Controller
 * @Date: 15:56 2018/1/23
 */
@Api(tags = "下拉列表")
@RestController
@RequestMapping("standard")
public class StandardController implements StandardApi {

    @Autowired
    private StandardService standardService;

    /**
     * @Author: 文婧瑶
     * @Description: 查询标准
     * @Date: 16:35 2018/1/30
     */
    @Override
    @ApiOperation(value = "下拉列表", response = QueryResponseResult.class, notes = "下拉列表")
    public QueryResponseResult<StandardResponse> findByFlag(@RequestParam Integer flag) {
        List<StandardResponse> list = standardService.findAll(flag);
        return new QueryResponseResult<>(CommonCode.SUCCESS, new QueryResult<StandardResponse>(list, null));
    }

    @Override
    @ApiOperation(value = "下拉列表目录", response = QueryResponseResult.class, notes = "下拉列表目录")
    public QueryResponseResult<StandardDirectoryResponse> findStandardFlags() {
        List<StandardDirectoryResponse> list = standardService.findStandardFlags();
        return new QueryResponseResult<StandardDirectoryResponse>(CommonCode.SUCCESS, new QueryResult<StandardDirectoryResponse>(list, null));
    }

}
