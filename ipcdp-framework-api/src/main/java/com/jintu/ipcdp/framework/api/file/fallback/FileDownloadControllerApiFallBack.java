package com.jintu.ipcdp.framework.api.file.fallback;

import com.jintu.ipcdp.framework.api.file.FileDownloadControllerApi;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/12 12:02
 * @Version 1.0
 */
@Component
public class FileDownloadControllerApiFallBack implements FileDownloadControllerApi {
    @Override
    public void download(String fileId, HttpServletResponse response) throws IOException {

    }
}
