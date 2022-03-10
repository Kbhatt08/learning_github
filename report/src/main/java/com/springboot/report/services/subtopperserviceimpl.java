package com.springboot.report.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.report.Dao.subtopperdao;
import com.springboot.report.entities.subtopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class subtopperserviceimpl implements subtopperservice {
    @Autowired
    EntityManager em;

    @Autowired
    private subtopperdao sdao;

    @Autowired
    public subtopperserviceimpl() {
    }

    @Override
    @Transactional
    public List<subtopper> getsubtopper(int id, int sub) {
        return (List<subtopper>) sdao.getsubtopper(id, sub);
        // return em.createNamedStoredProcedureQuery("callsubtopper").setParameter("id",
        // id).setParameter("sub", sub)
        // .getResultList();
    }

}
