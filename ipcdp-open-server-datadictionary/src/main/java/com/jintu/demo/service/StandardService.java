package com.jintu.demo.service;

import com.jintu.demo.dao.StandardDirectoryJpa;
import com.jintu.demo.dao.StandardJpa;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardDirectoryResponse;
import com.jintu.ipcdp.framework.model.datadictionary.resp.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2018/3/22.
 */
@Service
public class StandardService {


    @Autowired
    private StandardJpa standardJpa;

    @Autowired
    private StandardDirectoryJpa standardDirectoryJpa;

    public List<StandardResponse> findAll(Integer flag) {
        List<StandardResponse> list = standardJpa.findByStandardFlag(flag);
        return list;
    }

    public List<StandardDirectoryResponse> findStandardFlags() {

        List<StandardDirectoryResponse> list = standardDirectoryJpa.find();
        return list;
    }
}
