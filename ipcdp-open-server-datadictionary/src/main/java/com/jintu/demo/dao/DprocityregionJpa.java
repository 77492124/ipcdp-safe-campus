package com.jintu.demo.dao;

import com.jintu.ipcdp.framework.model.datadictionary.Dprocityregion;
import com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by dell on 2019/4/2.
 */
public interface DprocityregionJpa extends JpaRepository<Dprocityregion, Long> {


    @Query("SELECT new com.jintu.ipcdp.framework.model.datadictionary.resp.DprocityregionResponse(d.dId, d.dName,d.dParentid) " +
            "FROM Dprocityregion d")
    List<DprocityregionResponse> findAllByDLevelAndDParentid();


}
