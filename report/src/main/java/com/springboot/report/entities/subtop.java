package com.springboot.report.entities;

public class subtop {
    private int studentid;
    private String Student;
    private int Classid;
    private String subject;
    private int marksAchieved;

    public subtop(int studentid, String student, int classid, String subject, int marksAchieved) {
        this.studentid = studentid;
        Student = student;
        Classid = classid;
        this.subject = subject;
        this.marksAchieved = marksAchieved;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarksAchieved() {
        return marksAchieved;
    }

    public void setMarksAchieved(int marksAchieved) {
        this.marksAchieved = marksAchieved;
    }

    @Override
    public String toString() {
        return "subtop [Classid=" + Classid + ", Student=" + Student + ", marksAchieved=" + marksAchieved
                + ", studentid=" + studentid + ", subject=" + subject + "]";
    }

}
