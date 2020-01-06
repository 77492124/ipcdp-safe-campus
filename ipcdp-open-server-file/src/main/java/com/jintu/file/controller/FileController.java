package com.jintu.file.controller;

import com.jintu.file.config.FileServiceFactory;
import com.jintu.file.dao.FileInfoJpa;
import com.jintu.file.service.FileService;
import com.jintu.ipcdp.framework.api.file.FileControllerApi;
import com.jintu.ipcdp.framework.exception.ExceptionCast;
import com.jintu.ipcdp.framework.model.file.FileInfo;
import com.jintu.ipcdp.framework.model.file.ext.FileInfoBean;
import com.jintu.ipcdp.framework.model.file.response.FileInfoResult;
import com.jintu.ipcdp.framework.model.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class FileController implements FileControllerApi {

	@Autowired
	private FileServiceFactory fileServiceFactory;

	@Autowired
	private FileInfoJpa fileInfoJpa;


	/**
	 * 文件上传<br>
	 * 根据fileSource选择上传方式，目前仅实现了上传到本地<br>
	 * 如有需要可上传到第三方，如阿里云、七牛等
	 * 
	 * @param file
	 * @param fileSource
	 *            FileSource
	 * 
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "普通文件上传")
	@ApiImplicitParam(name = "fileSource", value = "LOCAL:本地（默认可不传），ALIYUN:阿里云")
	@Override
	public CommonResponseResult<FileInfoResult> upload(MultipartFile file, String fileSource) throws Exception {
		if (file.isEmpty()) {
			ExceptionCast.cast("上传文件不能为空");
		}
		FileService fileService = fileServiceFactory.getFileService(fileSource);
        FileInfoResult infoResult =new FileInfoResult();
        FileInfo fileInfo = fileService.upload(file);
        BeanUtils.copyProperties(fileInfo,infoResult);
        return new CommonResponseResult<FileInfoResult>(CommonCode.SUCCESS, infoResult);
	}

	/**
	 * layui富文本文件自定义上传
	 * 
	 * @param file
	 * @param fileSource
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "layui文件上传")
	@ApiImplicitParam(name = "fileSource", value = "LOCAL:本地（默认可不传），ALIYUN:阿里云")
	@Override
	public Map<String, Object> uploadLayui(MultipartFile file, String fileSource)
			throws Exception {
		if (file.isEmpty()) {
			ExceptionCast.cast("上传文件不能为空");
		}
		CommonResponseResult<FileInfoResult> queryResponseResult = upload(file, fileSource);
        FileInfoResult fileInfoResult = queryResponseResult.getData();

        Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		Map<String, Object> data = new HashMap<>();
		data.put("src", fileInfoResult.getUrl());
		map.put("data", data);

		return map;
	}

	/**
	 * 文件删除
	 * 
	 * @param id
	 */
	@ApiOperation(value = "文件删除")
	@ApiImplicitParam(name = "id", value = "id")
	@Override
	public ResponseResult delete(@PathVariable("id") String id) {
		FileInfo fileInfo = fileInfoJpa.findById(id).get();
		if (fileInfo != null) {
			FileService fileService = fileServiceFactory.getFileService(fileInfo.getSource());
			fileService.delete(fileInfo);
            return ResponseResult.SUCCESS();
		}
        return ResponseResult.FAIL();
    }



	/**
	 * 文件查询
	 * 
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "本地文件列表")
	@Override
	public QueryResponseResult<FileInfoBean> findFiles(Map<String, Object> params, @PathVariable("page") Integer page, @PathVariable Integer size) {
		Specification<FileInfo> specification = createSpecification(params);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		Page<FileInfo> all = fileInfoJpa.findAll(specification, pageRequest);
        List<FileInfo> content = all.getContent();
        ArrayList<FileInfoBean> fileInfoBeans = new ArrayList<>();
        content.forEach(s->{
            FileInfoBean fileInfoBean = new FileInfoBean();
            BeanUtils.copyProperties(s,fileInfoBean);
            fileInfoBeans.add(fileInfoBean);
        });
        return new QueryResponseResult<FileInfoBean>(CommonCode.SUCCESS, new QueryResult<FileInfoBean>(fileInfoBeans,all.getTotalElements()));
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<FileInfo> createSpecification(Map searchMap) {

		return new Specification<FileInfo>() {

			@Override
			public Predicate toPredicate(Root<FileInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				// 地址
				if (searchMap.get("path") != null && !"".equals(searchMap.get("id"))) {
					predicateList.add(cb.like(root.get("path").as(String.class), "%" + (String) searchMap.get("path") + "%"));
				}
				// url
				if (searchMap.get("url") != null && !"".equals(searchMap.get("url"))) {
					predicateList.add(cb.like(root.get("url").as(String.class), "%" + (String) searchMap.get("url") + "%"));
				}
				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};
	}

}
