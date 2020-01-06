package com.jintu.file.dao;

import com.jintu.ipcdp.framework.model.file.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 王金海
 * @Description:
 * @Date: Created by Administrator on 2019/3/17.
 * @Modified By:
 */
public interface FileInfoJpa extends JpaRepository<FileInfo,String>, JpaSpecificationExecutor<FileInfo> {
}
