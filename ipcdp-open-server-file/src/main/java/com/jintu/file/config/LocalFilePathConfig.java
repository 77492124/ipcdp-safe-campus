package com.jintu.file.config;

import com.jintu.ipcdp.framework.properties.JintuProperties;
import com.jintu.ipcdp.framework.properties.bean.FileLocalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 使系统加载jar包外的文件
 * 
 * @author 小威老师
 *
 */
@Configuration
public class LocalFilePathConfig {

	@Autowired
	private JintuProperties jintuProperties;

	@Bean
	public WebMvcConfigurer webMvcConfigurerAdapter() {
		FileLocalProperties fileLocal = jintuProperties.getFileLocal();
		return new WebMvcConfigurer() {

			/**
			 * 外部文件访问<br>
			 */
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler(fileLocal.getPrefix() + "/**")
						.addResourceLocations(ResourceUtils.FILE_URL_PREFIX + fileLocal.getPath() + File.separator);
			}

		};
	}
}
