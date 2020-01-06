package com.jintu.ipcdp.framework.api.file;

import com.jintu.ipcdp.framework.api.file.fallback.FileControllerApiFallBack;
import com.jintu.ipcdp.framework.client.JtServiceList;
import com.jintu.ipcdp.framework.model.file.ext.FileInfoBean;
import com.jintu.ipcdp.framework.model.file.response.FileInfoResult;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/3/17.
 * @Modified By:
 */
@FeignClient(name = JtServiceList.IPCDP_OPEN_SERVER_FILE, path = "/file/files/", fallback = FileControllerApiFallBack.class)
public interface FileControllerApi {

    @PostMapping
    CommonResponseResult<FileInfoResult> upload(@RequestParam("file") MultipartFile file, String fileSource) throws Exception;

    @PostMapping("/layui")
    Map<String, Object> uploadLayui(@RequestParam("file") MultipartFile file, String fileSource)
            throws Exception;

    @DeleteMapping("/{id}")
    ResponseResult delete(@PathVariable("id") String id);


    @GetMapping("/{page}/{size}")
    QueryResponseResult<FileInfoBean> findFiles(Map<String, Object> params, @PathVariable("page") Integer page, @PathVariable("size") Integer size);
}
