package com.springboot.report.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.report.entities.subtopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class topperofsub {
    @Autowired
    private EntityManager em;

    public List<subtopper> getdata(int id, int sub) {
        return em.createNamedStoredProcedureQuery("callsubtopper").setParameter("id", id).setParameter("sub", sub)
                .getResultList();
    }

}
