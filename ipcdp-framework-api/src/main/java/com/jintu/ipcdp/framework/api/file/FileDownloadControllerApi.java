package com.jintu.ipcdp.framework.api.file;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 常培兵
 * @Description: 描述
 * @Date 2019/4/16 17:11
 * @Version 1.0
 */
public interface FileDownloadControllerApi {
    /**
     * 文件下载
     * @param fileId 文件id
     * @param response 响应
     * @throws IOException
     */
    @GetMapping("download/{fileId}")
    void download(@PathVariable("fileId") String fileId, HttpServletResponse response) throws IOException;

}
