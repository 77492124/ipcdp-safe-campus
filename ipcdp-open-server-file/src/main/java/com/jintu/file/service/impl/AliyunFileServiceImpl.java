package com.jintu.file.service.impl;

import com.aliyun.oss.OSSClient;
import com.jintu.file.dao.FileInfoJpa;
import com.jintu.ipcdp.framework.model.file.FileInfo;
import com.jintu.ipcdp.framework.model.file.FileSource;
import com.jintu.ipcdp.framework.properties.JintuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云存储文件
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@Service("aliyunFileServiceImpl")
public class AliyunFileServiceImpl extends AbstractFileService {

	@Autowired
	private FileInfoJpa fileInfoJpa;

	@Override
	protected FileInfoJpa fileInfoJpa() {
		return fileInfoJpa;
	}

	@Override
	protected FileSource fileSource() {
		return FileSource.ALIYUN;
	}

	@Autowired
	private OSSClient ossClient;


	@Autowired
	private JintuProperties jintuProperties;

	@Override
	protected void uploadFile(MultipartFile file, FileInfo fileInfo) throws Exception {
		String name = fileInfo.getName();
		String[] split = fileInfo.getName().split("\\.");
		fileInfo.setName(fileInfo.getId()+"."+split[split.length-1]);
		ossClient.putObject(jintuProperties.getFileAliyun().getBucketName(), fileInfo.getName(), file.getInputStream());
		fileInfo.setUrl(jintuProperties.getFileAliyun().getDomain() + "/" + fileInfo.getName());
//		fileInfo.setName(name);
	}

	@Override
	protected boolean deleteFile(FileInfo fileInfo) {
		ossClient.deleteObject(jintuProperties.getFileAliyun().getBucketName(), fileInfo.getName());
		return true;
	}

}
