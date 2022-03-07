package com.springboot.report.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.report.entities.Topperdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class topperofclass {

    @Autowired
    private EntityManager em;

    public List<Topperdata> getdata(int id) {
        return em.createNamedStoredProcedureQuery("calltopper").setParameter("id", id).getResultList();
    }
}
