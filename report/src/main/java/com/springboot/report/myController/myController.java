package com.springboot.report.myController;

import java.util.List;

import com.springboot.report.entities.Topperdata;
import com.springboot.report.entities.student;
import com.springboot.report.entities.subtopper;
import com.springboot.report.services.studentService;
import com.springboot.report.services.subtopperservice;
import com.springboot.report.services.topperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @Autowired
    private studentService sService;
    @Autowired
    private topperService tService;
    @Autowired
    private subtopperservice subservice;

    @GetMapping("/home")
    public String home() {
        return "Welcome To The Home Page";
    }

    @GetMapping("/student")
    public List<student> getStudents() {
        return this.sService.getStudents();
    }

    @GetMapping("/topper")
    public List<Topperdata> gettopper(@RequestParam int id) {
        return this.tService.gettopper(id);
    }

    @GetMapping("/subtopper")
    public List<subtopper> getsubtopper(@RequestParam int id, @RequestParam int sub) {
        return this.subservice.getsubtopper(id, sub);
    }
}
