package com.springboot.report.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table
@NamedStoredProcedureQuery(name = "callsubtopper", procedureName = "USP_bysub", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = int.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sub", type = int.class) })
public class subtopper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentid;
    private String Student;
    private int Classid;
    private String Class;
    private int Totalmarks;

    public subtopper(int studentid, String student, int classid, String classname, int totalmarks) {
        this.studentid = studentid;
        Student = student;
        Classid = classid;
        Class = classname;
        Totalmarks = totalmarks;
    }

    public subtopper() {
    }

    @Override
    public String toString() {
        return "subtopper [Class=" + Class + ", Classid=" + Classid + ", Student=" + Student + ", Totalmarks="
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
