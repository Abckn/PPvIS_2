package com.company.controller;

import java.util.ArrayList;
import java.util.List;
import com.company.loader.Loader;
import com.company.model.Student;
import com.company.saver.Saver;


public class Controller {

    private List<Student> students;
    private Loader loader;
    private Saver saver;

    public Controller(List<Student> students) {
        this.students = students;
        loader = new Loader();
        saver = new Saver();
    }

    public void load(String filePath) {
        this.students = loader.load(filePath);
    }

    public void save(String filePath) {
        saver.save(this.students, filePath);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(String name, String group, int first, int second, int third,
                           int fourth, int five, int six, int seven, int eigth, int nine, int ten , int result) {
        Student student = new Student();
        student.setName(name);
        student.setGroup(group);
        student.setFirstTerm(first);
        student.setSecondTerm(second);
        student.setThirdTerm(third);
        student.setFourthTerm(fourth);
        student.setFiveTerm(five);
        student.setSixthTerm(six);
        student.setSeventhTerm(seven);
        student.setEighthTerm(eigth);
        student.setNinthTerm(nine);
        student.setTenthTerm(ten);



        students.add(student);
    }

    public void deleteStudents(List<Student> students) {
        for (Student student : students) {
            this.students.remove(student);
        }
    }



    public List<Student> find_Name(String name, List<Student> studentsList) {
        List<Student> students = new ArrayList<Student>();
        for (Student student : studentsList) {
            if (student.getName().contains(name)) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> find_in_borders(String group, String lower,String upper, List<Student> studentList ){
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(lower);
        Integer i1 = Integer.valueOf(upper);
        for (Student student : studentList) {
            if (student.getGroup().contains(group) && student.getTotal() >= i2 && student.getTotal() <=i1) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> find_group(String group, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        for (Student student : studentList) {
            if (student.getGroup().contains(group)) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> find_total(String lower,String upper, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(lower);
        Integer i1 = Integer.valueOf(upper);
        for (Student student : studentList) {
            if (student.getTotal() >= i2 && student.getTotal() <=i1) {
                students.add(student);
            }
        }
        return students;
    }
}