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
    @Column(name = "class")
    private String Class;
    private String subjectName;
    private int marksAchieved;

    public subtopper(int studentid, String student, int classid, String classname, String subjectName,
            int marksAchieved) {
        this.studentid = studentid;
        Student = student;
        Classid = classid;
        Class = classname;
        this.subjectName = subjectName;
        this.marksAchieved = marksAchieved;
    }

    public subtopper() {
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

    public String getClass1() {
        return Class;
    }

    public void setClass(String classname) {
        Class = classname;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarksAchieved() {
        return marksAchieved;
    }

    public void setMarksAchieved(int marksAchieved) {
        this.marksAchieved = marksAchieved;
    }

    @Override
    public String toString() {
        return "subtopper [Class=" + Class + ", Classid=" + Classid + ", Student=" + Student + ", marksAchieved="
                + marksAchieved + ", studentid=" + studentid + ", subjectName=" + subjectName + "]";
    }

}
