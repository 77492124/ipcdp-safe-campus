package com.jintu.file.config;

import com.jintu.file.service.FileService;
import com.jintu.ipcdp.framework.model.file.FileSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * FileService工厂<br>
 * 将各个实现类放入map
 * 
 * @author 小威老师
 *
 */
@Configuration
public class FileServiceFactory {

	private Map<FileSource, FileService> map = new HashMap<>();

	@Autowired
	private FileService localFileServiceImpl;
	@Autowired
	private FileService aliyunFileServiceImpl;

	@PostConstruct
	public void init() {
		map.put(FileSource.LOCAL, localFileServiceImpl);
		map.put(FileSource.ALIYUN, aliyunFileServiceImpl);

	}

	/**
	 * 根据文件源获取具体的实现类
	 *
	 * @param fileSource
	 * @return
	 */
	public FileService getFileService(String fileSource) {
		if (StringUtils.isBlank(fileSource)) {// 默认用本地存储
			return localFileServiceImpl;
		}

		FileService fileService = map.get(FileSource.valueOf(fileSource));
		if (fileService == null) {
			throw new IllegalArgumentException("请检查FileServiceFactory类的init方法，看是否有" + fileSource + "对应的实现类");
		}
		return fileService;
	}
}
