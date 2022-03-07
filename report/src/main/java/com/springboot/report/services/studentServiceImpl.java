package com.springboot.report.services;

import java.util.List;

import com.springboot.report.Dao.StudentDao;
import com.springboot.report.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpl implements studentService {
    @Autowired
    private StudentDao studao;

    public studentServiceImpl() {

    }

    @Override
    public List<student> getStudents() {
        return studao.findAll();
    }

}
