package com.springboot.report.myController;

import java.util.List;

import com.springboot.report.Dao.topperofclass;
import com.springboot.report.Dao.topperofsub;
import com.springboot.report.entities.Topperdata;
import com.springboot.report.entities.student;
import com.springboot.report.entities.subtopper;
import com.springboot.report.services.studentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @Autowired
    private studentService sService;
    @Autowired
    private topperofclass tao;
    @Autowired
    private topperofsub sao;

    @GetMapping("/subtopper/{id}/{sub}")
    public List<subtopper> getsub(@PathVariable int id, @PathVariable int sub) {
        return sao.getdata(id, sub);
    }

    @GetMapping("/topclass/{id}")
    public List<Topperdata> getres(@PathVariable int id) {
        return tao.getdata(id);
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome To The Home Page";
    }

    @GetMapping("/student")
    public List<student> getStudents() {
        return this.sService.getStudents();
    }
}
