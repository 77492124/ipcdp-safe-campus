package com.jintu.file.config;

import com.aliyun.oss.OSSClient;
import com.jintu.ipcdp.framework.properties.JintuProperties;
import com.jintu.ipcdp.framework.properties.bean.FileAliyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云配置
 * 
 * @author 小威老师
 *
 */
@Configuration
public class AliyunConfig {

	@Autowired
	private JintuProperties jintuProperties;

	/**
	 * 阿里云文件存储client
	 * 
	 */
	@Bean
	public OSSClient ossClient() {
		FileAliyunProperties fileAliyun = jintuProperties.getFileAliyun();
		OSSClient ossClient = new OSSClient(fileAliyun.getEndpoint(), fileAliyun.getAccessKeyId(), fileAliyun.getAccessKeySecret());
		return ossClient;
	}

}
