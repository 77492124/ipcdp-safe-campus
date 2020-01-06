package com.jintu.ipcdp.framework.api.file.fallback;

import com.jintu.ipcdp.framework.api.file.FileControllerApi;
import com.jintu.ipcdp.framework.model.file.ext.FileInfoBean;
import com.jintu.ipcdp.framework.model.file.response.FileInfoResult;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/12 12:02
 * @Version 1.0
 */
@Component
public class FileControllerApiFallBack implements FileControllerApi {
    @Override
    public CommonResponseResult<FileInfoResult> upload(MultipartFile file, String fileSource) throws Exception {
        return CommonResponseResult.SERVER_ANOMALY();
    }

    @Override
    public Map<String, Object> uploadLayui(MultipartFile file, String fileSource) throws Exception {
        return null;
    }

    @Override
    public ResponseResult delete(String id) {
        return ResponseResult.SERVER_ANOMALY();
    }

    @Override
    public QueryResponseResult<FileInfoBean> findFiles(Map<String, Object> params, Integer page, Integer size) {
        return QueryResponseResult.SERVER_ANOMALY();
    }
}
