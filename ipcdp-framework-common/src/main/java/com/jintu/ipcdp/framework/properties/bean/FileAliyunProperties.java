package com.jintu.ipcdp.framework.properties.bean;

import lombok.Data;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/5/9.
 * @Modified By:
 */
@Data
public class FileAliyunProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String domain;
}
