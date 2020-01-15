package com.jintu.ipcdp.framework.api.safecampus.fallback;

import com.jintu.ipcdp.framework.api.safecampus.WatchListControllerApi;
import com.jintu.ipcdp.framework.model.response.CommonCode;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 17:16
 * @Version 1.0
 */
@Component
public class WatchListControllerApiFallBack implements WatchListControllerApi {
    @Override
    public QueryResponseResult<FindWatchListResponseDTO> findWatchList(FindWatchListRequestDTO requestDTO) {
        return new QueryResponseResult<>(CommonCode.SERVER_ANOMALY);
    }

    @Override
    public void exportWatchList(ExportWatchListRequestDTO requestDTO, HttpServletResponse response) throws Exception{

    }
}
