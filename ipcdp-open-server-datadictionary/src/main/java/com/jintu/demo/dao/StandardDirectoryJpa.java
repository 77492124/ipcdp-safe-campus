package com.jintu.demo.dao;

import com.jintu.ipcdp.framework.model.datadictionary.StandardDirectory;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by dell on 2019/4/3.
 */
public interface StandardDirectoryJpa extends JpaRepository<StandardDirectory, Integer> {

    @Query("SELECT new com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse(s.standardFlag, s.standardName) " +
            "FROM StandardDirectory s ")
    List<StandardDirectoryResponse> find();

}
