package com.jintu.file.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.jintu.file.dao.FileInfoJpa;
import com.jintu.ipcdp.framework.api.file.FileDownloadControllerApi;
import com.jintu.ipcdp.framework.model.file.FileInfo;
import com.jintu.ipcdp.framework.model.file.FileSource;
import com.jintu.ipcdp.framework.properties.JintuProperties;
import io.swagger.annotations.ApiOperation;
import lombok.Cleanup;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Optional;

/**
 * @Author 常培兵
 * @Description: 描述
 * @Date 2019/4/16 17:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/fileDownload")
public class FileDownloadController implements FileDownloadControllerApi {

    @Autowired
    private FileInfoJpa fileInfoJpa;

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private JintuProperties jintuProperties;

    @ApiOperation(value = "文件下载")
    @Override
    public void download(@PathVariable("fileId") String fileId, HttpServletResponse response) throws IOException {
        Optional<FileInfo> fileInfo = fileInfoJpa.findById(fileId);
        @Cleanup
        OutputStream outputStream = response.getOutputStream();
        if (fileInfo.isPresent()) {
            // 配置文件下载
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileInfo.get().getName());
            if (fileInfo.get().getSource().equals(FileSource.ALIYUN.name())) {
                // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
                OSSObject ossObject = ossClient.getObject(jintuProperties.getFileAliyun().getBucketName(), fileInfo.get().getName());
                // 读取文件内容。
                System.out.println("Object content:");
                InputStream in = ossObject.getObjectContent();
                byte[] bytes = IOUtils.toByteArray(in);
                outputStream.write(bytes);
                ossClient.shutdown();
            }else {

                File file = new File(fileInfo.get().getImgPath());
                if (file.exists()) {
                    byte[] buffer = new byte[1024];
                    @Cleanup FileInputStream fis = new FileInputStream(file);
                    byte[] bytes = IOUtils.toByteArray(fis);
                    outputStream.write(bytes);
                }
            }
        }
    }

}
