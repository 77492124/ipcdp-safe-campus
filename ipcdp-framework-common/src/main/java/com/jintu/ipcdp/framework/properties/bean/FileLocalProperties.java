package com.jintu.ipcdp.framework.properties.bean;

import lombok.Data;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/5/9.
 * @Modified By:
 */
@Data
public class FileLocalProperties {
    /**
     * 上传文件存储在本地的根路径
     */
    private String path="d:/localFile";
    /**
     * url前缀
     */
    private String prefix="/statics";
    /**
     * 请求地址前缀
     */
    private String urlPrefix;
}
