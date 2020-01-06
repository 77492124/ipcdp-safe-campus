package com.jintu.ipcdp.framework.model.file.response;

import lombok.Data;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/3/18.
 * @Modified By:
 */
@Data
public class FileInfoResult {
    private String size;
    private String url;
    private String contentType;
}
