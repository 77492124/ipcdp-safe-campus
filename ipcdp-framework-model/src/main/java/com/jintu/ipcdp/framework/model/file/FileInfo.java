package com.jintu.ipcdp.framework.model.file;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class FileInfo implements Serializable {


	@Id
	/** 文件的md5 */
	private String id;
	/** 原始文件名 */
	private String name;
	/** 是否是图片 */
	private Boolean isImg;
	private String contentType;
	private long size;
	private String imgPath;
	private String url;
	/**
	 * 文件来源
	 * 
	 * @see FileSource
	 */
	private String source;
	private Date createTime;
}
