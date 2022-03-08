package com.springboot.report.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.report.entities.subtopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class subtopperserviceimpl implements subtopperservice {
    @Autowired
    EntityManager em;

    @Autowired
    public subtopperserviceimpl() {
    }

    @Override
    public List<subtopper> getsubtopper(int id, int sub) {
        return em.createNamedStoredProcedureQuery("callsubtopper").setParameter("id", id).setParameter("sub", sub)
                .getResultList();
    }

}
