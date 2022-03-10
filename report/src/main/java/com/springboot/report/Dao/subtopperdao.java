package com.springboot.report.Dao;

import java.util.List;

import com.springboot.report.entities.subtopper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface subtopperdao extends JpaRepository<subtopper, Integer> {

    @Procedure("USP_bysub")
    List<subtopper> getsubtopper(@Param("id") int id, @Param("sub") int sub);

}
