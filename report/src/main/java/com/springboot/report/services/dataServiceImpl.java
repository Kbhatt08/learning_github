package com.springboot.report.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springboot.report.Dao.sudentdataDao;
import com.springboot.report.entities.Topper;
import com.springboot.report.entities.studentdata;
import com.springboot.report.entities.subtop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dataServiceImpl implements dataService {

    @Autowired
    private sudentdataDao ddao;

    @Autowired
    public dataServiceImpl() {
    }

    @Override
    public List<studentdata> getdata() {
        return ddao.findAll();
    }

    @Override
    public studentdata addData(studentdata data) {
        return ddao.save(data);
    }

    @Override
    public Optional<studentdata> getdata(int id) {
        return ddao.findById(id);
    }

    static List<Topper> find(int grade, List<studentdata> student) {
        List<Topper> list = new ArrayList<>();
        student.forEach(e -> {
            if (e.getClass1() == grade) {
                int marks = (e.getEnglishmarks() + e.getHindimarks() + e.getMathmarks() + e.getSciencemarks()
                        + e.getSocialscmarks()) / 5;
                Topper topper = new Topper(e.getStudentid(), e.getStudentName(), e.getClass1(), marks);
                list.add(topper);
            }
        });
        return list;
    }

    @Override
    public List<Topper> gettop(int grade) {
        List<Topper> list = find(grade, ddao.findAll());
        int max = 0;
        for (Topper T : list) {
            if (T.getTotalmarks() > max) {
                max = T.getTotalmarks();
            }
        }
        List<Topper> newList = new ArrayList<>();
        for (Topper T : list) {
            if (T.getTotalmarks() == max) {
                newList.add(T);
            }
        }
        return newList;
    }

    @Override
    public studentdata updateData(studentdata data) {
        return ddao.save(data);
    }

    @Override
    public void deleteData(int id) {
        studentdata student = ddao.getById(id);
        ddao.delete(student);
    }

    static List<subtop> findbysub(int grade, String subject, List<studentdata> student) {
        List<subtop> list = new ArrayList<>();
        student.forEach(e -> {
            if (e.getClass1() == grade) {
                int marks;
                if (subject == "english") {
                    marks = e.getEnglishmarks();
                    subtop topper = new subtop(e.getStudentid(), e.getStudentName(), e.getClass1(), "english", marks);
                    list.add(topper);
                }
                if (subject == "hindi") {
                    marks = e.getHindimarks();
                    subtop topper = new subtop(e.getStudentid(), e.getStudentName(), e.getClass1(), "hindi", marks);
                    list.add(topper);
                }
                if (subject == "maths") {
                    marks = e.getMathmarks();
                    subtop topper = new subtop(e.getStudentid(), e.getStudentName(), e.getClass1(), "maths", marks);
                    list.add(topper);
                }
                if (subject == "science") {
                    marks = e.getSciencemarks();
                    subtop topper = new subtop(e.getStudentid(), e.getStudentName(), e.getClass1(), "science", marks);
                    list.add(topper);
                }
                if (subject == "socialscience") {
                    marks = e.getSocialscmarks();
                    subtop topper = new subtop(e.getStudentid(), e.getStudentName(), e.getClass1(), "socialscience",
                            marks);
                    list.add(topper);
                }
            }
        });
        return list;
    }

    @Override
    public List<subtop> getsubtop(int grade, String subject) {
        List<subtop> list = findbysub(grade, subject, ddao.findAll());
        int max = 0;
        for (subtop T : list) {
            if (T.getMarksAchieved() > max) {
                max = T.getMarksAchieved();
            }
        }
        List<subtop> newList = new ArrayList<>();
        for (subtop T : list) {
            if (T.getMarksAchieved() == max) {
                newList.add(T);
            }
        }
        return newList;
    }

}