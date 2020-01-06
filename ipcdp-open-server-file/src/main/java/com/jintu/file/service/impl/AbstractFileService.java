package com.jintu.file.service.impl;

import com.jintu.file.dao.FileInfoJpa;
import com.jintu.file.service.FileService;
import com.jintu.file.utils.FileUtil;
import com.jintu.ipcdp.framework.model.file.FileInfo;
import com.jintu.ipcdp.framework.model.file.FileSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Slf4j
public abstract class AbstractFileService implements FileService {

	protected abstract FileInfoJpa fileInfoJpa();
//	@Autowired
//	private FileInfoJpa fileInfoJpa;

	@Override
	public FileInfo upload(MultipartFile file) throws Exception {
		FileInfo fileInfo = FileUtil.getFileInfo(file);
		// 先根据文件md5查询记录
		Optional<FileInfo> oldFileInfo = fileInfoJpa().findById(fileInfo.getId());

		// 如果已存在文件，避免重复上传同一个文件
		if (oldFileInfo.isPresent()) {
			return oldFileInfo.get();
		}

		if (!fileInfo.getName().contains(".")) {
			throw new IllegalArgumentException("缺少后缀名");
		}

		uploadFile(file, fileInfo);

		fileInfo.setSource(fileSource().name());// 设置文件来源
		fileInfoJpa().save(fileInfo);// 将文件信息保存到数据库

		log.info("上传文件：{}", fileInfo);

		return fileInfo;
	}

	/**
	 * 文件来源
	 * 
	 * @return
	 */
	protected abstract FileSource fileSource();

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param fileInfo
	 */
	protected abstract void uploadFile(MultipartFile file, FileInfo fileInfo) throws Exception;

	@Override
	public void delete(FileInfo fileInfo) {
		deleteFile(fileInfo);
		fileInfoJpa().deleteById(fileInfo.getId());
		log.info("删除文件：{}", fileInfo);
	}

	/**
	 * 删除文件资源
	 * 
	 * @param fileInfo
	 * @return
	 */
	protected abstract boolean deleteFile(FileInfo fileInfo);




}
