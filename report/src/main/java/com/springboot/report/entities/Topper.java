package com.springboot.report.entities;

public class Topper {
    private int studentid;
    private String Student;
    private int Classid;
    private int Totalmarks;

    public Topper(int studentid, String student, int classid, int totalmarks) {
        this.studentid = studentid;
        Student = student;
        Classid = classid;
        Totalmarks = totalmarks;
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

    public int getTotalmarks() {
        return Totalmarks;
    }

    public void setTotalmarks(int totalmarks) {
        Totalmarks = totalmarks;
    }

    @Override
    public String toString() {
        return "Topper [Classid=" + Classid + ", Student=" + Student + ", Totalmarks=" + Totalmarks + ", studentid="
                + studentid + "]";
    }

}
