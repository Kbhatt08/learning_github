package com.springboot.report.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "topper")
@NamedStoredProcedureQuery(name = "calltopper", procedureName = "USP_byclass", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = int.class) })
public class Topperdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private int studentid;
    @Column
    private String Student;
    @Column
    private int Classid;
    @Column
    private String Class;
    @Column
    private int Totalmarks;

    public Topperdata(int studentid, String student, int classid, String classname, int totalmarks) {
        this.studentid = studentid;
        Student = student;
        Classid = classid;
        Class = classname;
        Totalmarks = totalmarks;
    }

    public Topperdata() {
    }

    @Override
    public String toString() {
        return "Topperdata [Class=" + Class + ", Classid=" + Classid + ", Student=" + Student + ", Totalmarks="
                + Totalmarks + ", studentid=" + studentid + "]";
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String student) {
        Student = student;
    }

    public int getClassid() {
        return Classid;
    }

    public void setClassid(int classid) {
        Classid = classid;
    }

    public String getClassname() {
        return Class;
    }

    public void setClass(String classname) {
        Class = classname;
    }

    public int getTotalmarks() {
        return Totalmarks;
    }

    public void setTotalmarks(int totalmarks) {
        Totalmarks = totalmarks;
    }
}
