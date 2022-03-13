package com.springboot.report.myController;

import java.util.List;
import java.util.Optional;

import com.springboot.report.entities.Topper;
import com.springboot.report.entities.studentdata;
import com.springboot.report.entities.subtop;

import com.springboot.report.services.dataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @Autowired
    private dataService ds;

    @GetMapping("/home")
    public String home() {
        return "Welcome To The Home Page";
    }

    @GetMapping("/studentdata")
    public List<studentdata> getdata() {
        return this.ds.getdata();
    }

    @GetMapping("/studentdatabyid")
    public Optional<studentdata> getdata(@RequestParam int studentid) {
        return this.ds.getdata(studentid);
    }

    @PostMapping("/studentdata")
    public studentdata addData(@RequestBody studentdata student) {
        return this.ds.addData(student);
    }

    @PutMapping("/studentdata")
    public studentdata updateData(@RequestBody studentdata student) {
        return this.ds.updateData(student);
    }

    @DeleteMapping("/studentdata")
    public ResponseEntity<HttpStatus> deleteData(@RequestParam int studentid) {
        try {
            this.ds.deleteData(studentid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/studenttopper")
    public List<Topper> gettop(@RequestParam int classid) {
        return this.ds.gettop(classid);
    }

    @GetMapping("/studentsubtopper")
    public List<subtop> getsubtop(@RequestParam int classid, @RequestParam String subject) {

        return this.ds.getsubtop(classid, subject);
    }
}
