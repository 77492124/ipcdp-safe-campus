package com.jintu.safecampus.common.util;

import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.SchoolSysResourcesDTO;
import com.jintu.safecampus.dal.model.SchoolSysResources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Parker
 * @Description: 业务工具
 * @Date 2020/1/9 10:14
 * @Version 1.0
 */
@Component
public class BusinessUtils {

    /**
     * 递归生成树
     * @param parentId 上级id
     * @param sysResources 所有资源列表
     * @return 数
     */
    public List<SchoolSysResourcesDTO> findChildList(Long parentId, List<SchoolSysResources> sysResources) {
        List<SchoolSysResourcesDTO> resultList = null;
        if (parentId == null) {
            resultList = sysResources.stream().filter(s -> s.getLevel() == 1)
                    .map(s -> new SchoolSysResourcesDTO()
                            .setId(s.getId())
                            .setParentId(s.getParentId())
                            .setLevel(s.getLevel())
                            .setResourceName(s.getResourceName())
                            .setResourcePath(s.getResourcePath())
                            .setResourceIcon(s.getResourceIcon())
                            .setRemarks(s.getRemarks()))
                    .collect(Collectors.toList());
        } else {
            resultList = sysResources.stream().filter(s -> parentId.equals(s.getParentId()))
                    .map(s -> new SchoolSysResourcesDTO()
                            .setId(s.getId())
                            .setParentId(s.getParentId())
                            .setLevel(s.getLevel())
                            .setResourceName(s.getResourceName())
                            .setResourcePath(s.getResourcePath())
                            .setResourceIcon(s.getResourceIcon())
                            .setRemarks(s.getRemarks()))
                    .collect(Collectors.toList());
        }
        for (SchoolSysResourcesDTO schoolSysResourcesDTO : resultList) {
            schoolSysResourcesDTO.setChildList(this.findChildList(schoolSysResourcesDTO.getId(), sysResources));
        }
        if (resultList.size() == 0) {
            return null;
        }
        return resultList;
    }
}
