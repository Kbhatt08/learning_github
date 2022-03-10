package com.springboot.report.Dao;

import java.util.List;

import com.springboot.report.entities.Topperdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface topperdao extends JpaRepository<Topperdata, Integer> {
    @Procedure("USP_byclass")
    List<Topperdata> gettopper(int id);
}
