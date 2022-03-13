package com.springboot.report.services;

import java.util.List;
import java.util.Optional;

import com.springboot.report.entities.Topper;
import com.springboot.report.entities.studentdata;
import com.springboot.report.entities.subtop;

public interface dataService {
    public List<studentdata> getdata();

    public studentdata addData(studentdata data);

    public Optional<studentdata> getdata(int id);

    public List<Topper> gettop(int classid);

    public List<subtop> getsubtop(int classid, String subject);

    public studentdata updateData(studentdata data);

    public void deleteData(int id);
}
