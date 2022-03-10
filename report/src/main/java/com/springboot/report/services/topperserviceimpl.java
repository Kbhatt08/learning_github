package com.springboot.report.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.report.Dao.topperdao;
import com.springboot.report.entities.Topperdata;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class topperserviceimpl implements topperService {

    @Autowired
    public topperdao tdao;

    @Autowired
    public topperserviceimpl() {

    }

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Topperdata> gettopper(int id) {
        return (List<Topperdata>) tdao.gettopper(id);
        // return em.createNamedStoredProcedureQuery("calltopper").setParameter("id",
        // id).getResultList();
    }
}
