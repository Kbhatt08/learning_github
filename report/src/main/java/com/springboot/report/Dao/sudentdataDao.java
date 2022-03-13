package com.springboot.report.Dao;

//import java.util.List;
import com.springboot.report.entities.studentdata;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface sudentdataDao extends JpaRepository<studentdata, Integer> {
    // @Procedure("USP_addData")
    // List<studentdata> addStudent(studentdata sty);
}
