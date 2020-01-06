package com.jintu.demo.service;

import com.jintu.demo.dao.DprocityregionJpa;
import com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrcService {

	@Autowired
	private DprocityregionJpa dprocityregionJpa;

	public List<DprocityregionResponse> findDprocityregion(){
        List<DprocityregionResponse> dprocityregionJpaAll = dprocityregionJpa.findAllByDLevelAndDParentid();
        return findParent(100000L, dprocityregionJpaAll);
    }

    private   List<DprocityregionResponse> findParent(Long currentId, List<DprocityregionResponse> rootMenu) {
        List<DprocityregionResponse> parentList = new ArrayList<DprocityregionResponse>();
        for (DprocityregionResponse menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(String.valueOf(menu.getDParentid()))) {
                if (String.valueOf(menu.getDParentid()).equals(String.valueOf(currentId))) {
                    parentList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (DprocityregionResponse menu : parentList) {// 没有url子菜单还有子菜单
            // 递归
            menu.setDprocityregionBeans(findParent(menu.getDId(), rootMenu));
        } // 递归退出条件
        if (parentList.size() == 0) {
            return null;
        }
        return parentList;
    }

}
