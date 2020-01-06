package com.jintu.demo.dao;

import com.jintu.ipcdp.framework.model.datadictionary.Standard;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: 文婧瑶
 * @Description: 标准dao
 * @Date: 16:45 2018/3/22
 */
public interface StandardJpa extends JpaRepository<Standard, Integer> {

    @Query("SELECT new com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse(s.standardId, s.standardCode, s.standardContent) " +
            "FROM Standard s WHERE s.standardFlag = ?1 ")
    List<StandardResponse> findByStandardFlag(Integer standardFlag);

}
