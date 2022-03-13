package com.springboot.report.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class studentdata {
    @Id
    private int Studentid;
    private int Class;
    private String StudentName;
    private int mathmarks;
    private int sciencemarks;
    private int hindimarks;
    private int englishmarks;
    private int socialscmarks;

    public studentdata() {
    }

    public studentdata(int studentid, int grade, String studentName, int mathmarks, int sciencemarks, int hindimarks,
            int englishmarks, int socialscmarks) {
        Studentid = studentid;
        Class = grade;
        StudentName = studentName;
        this.mathmarks = mathmarks;
        this.sciencemarks = sciencemarks;
        this.hindimarks = hindimarks;
        this.englishmarks = englishmarks;
        this.socialscmarks = socialscmarks;
    }

    public int getStudentid() {
        return Studentid;
    }

    public void setStudentid(int studentid) {
        Studentid = studentid;
    }

    public int getClass1() {
        return Class;
    }

    public void setClass(int class1) {
        Class = class1;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getMathmarks() {
        return mathmarks;
    }

    public void setMathmarks(int mathmarks) {
        this.mathmarks = mathmarks;
    }

    public int getSciencemarks() {
        return sciencemarks;
    }

    public void setSciencemarks(int sciencemarks) {
        this.sciencemarks = sciencemarks;
    }

    public int getHindimarks() {
        return hindimarks;
    }

    public void setHindimarks(int hindimarks) {
        this.hindimarks = hindimarks;
    }

    public int getEnglishmarks() {
        return englishmarks;
    }

    public void setEnglishmarks(int englishmarks) {
        this.englishmarks = englishmarks;
    }

    public int getSocialscmarks() {
        return socialscmarks;
    }

    public void setSocialscmarks(int socialscmarks) {
        this.socialscmarks = socialscmarks;
    }

    @Override
    public String toString() {
        return "studentdata [Class=" + Class + ", StudentName=" + StudentName + ", Studentid=" + Studentid
                + ", englishmarks=" + englishmarks + ", hindimarks=" + hindimarks + ", mathmarks=" + mathmarks
                + ", sciencemarks=" + sciencemarks + ", socialscmarks=" + socialscmarks + "]";
    }

}
