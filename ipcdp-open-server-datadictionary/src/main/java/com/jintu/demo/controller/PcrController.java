package com.jintu.demo.controller;

import com.jintu.demo.service.PrcService;
import com.jintu.ipcdp.framework.api.datadictionary.PcrApi;
import com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "省市区")
@RestController
@RequestMapping("pcr")
public class PcrController implements PcrApi {

	@Autowired
	private PrcService prcService;

	@Override
	@ApiOperation(value = "省市区", response = QueryResponseResult.class, notes = "省市区")
	public QueryResponseResult<DprocityregionResponse> procityregion() {

		List<DprocityregionResponse> pros = prcService.findDprocityregion();
		return new QueryResponseResult(CommonCode.SUCCESS, new QueryResult<DprocityregionResponse>(pros, null));
	}

}
