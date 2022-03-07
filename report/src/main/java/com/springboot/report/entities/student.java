package com.springboot.report.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStudent;
    private String StudentName;
    private int Class;

    public student() {
    }

    public student(Integer idStudent, String studentName, int classid) {
        this.idStudent = idStudent;
        StudentName = studentName;
        Class = classid;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getClassid() {
        return Class;
    }

    public void setClass(int classid) {
        Class = classid;
    }

    @Override
    public String toString() {
        return "student [Class=" + Class + ", StudentName=" + StudentName + ", idStudent=" + idStudent + "]";
    }
}
