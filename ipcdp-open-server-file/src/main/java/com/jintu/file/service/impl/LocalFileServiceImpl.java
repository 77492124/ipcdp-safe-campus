package com.jintu.file.service.impl;

import com.jintu.file.dao.FileInfoJpa;
import com.jintu.file.utils.FileUtil;
import com.jintu.ipcdp.framework.model.file.FileInfo;
import com.jintu.ipcdp.framework.model.file.FileSource;
import com.jintu.ipcdp.framework.properties.JintuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

/**
 * 本地存储文件<br>
 * 该实现文件服务只能部署一台<br>
 * 如多台机器间能共享到一个目录，即可部署多台
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@Service("localFileServiceImpl")
public class LocalFileServiceImpl extends AbstractFileService {

	@Autowired
	private FileInfoJpa fileInfoJpa;
	@Autowired
	private JintuProperties jintuProperties;
	@Override
	protected FileInfoJpa fileInfoJpa() {
		return fileInfoJpa;
	}

	@Override
	protected FileSource fileSource() {
		return FileSource.LOCAL;
	}

	@Override
	protected void uploadFile(MultipartFile file, FileInfo fileInfo) throws Exception {
		int index = fileInfo.getName().lastIndexOf(".");
		// 文件扩展名
		String fileSuffix = fileInfo.getName().substring(index);

		String suffix = "/" + LocalDate.now().toString().replace("-", "/") + "/" + fileInfo.getId() + fileSuffix;

		String path = jintuProperties.getFileLocal().getPath() + suffix;
		String url = jintuProperties.getFileLocal().getUrlPrefix() + suffix;
		fileInfo.setImgPath(path);
		fileInfo.setUrl(url);

		FileUtil.saveFile(file, path);

	}

	@Override
	protected boolean deleteFile(FileInfo fileInfo) {
		return FileUtil.deleteFile(fileInfo.getImgPath());
	}

}
