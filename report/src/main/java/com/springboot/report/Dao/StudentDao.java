package com.springboot.report.Dao;

import com.springboot.report.entities.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<student, Integer> {

}
