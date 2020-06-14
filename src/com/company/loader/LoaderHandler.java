package com.company.loader;

import com.company.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class LoaderHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bGroup = false;
    private boolean t1 = false;
    private boolean t2 = false;
    private boolean t3 = false;
    private boolean t4 = false;
    private boolean t5 = false;
    private boolean t6 = false;
    private boolean t7 = false;
    private boolean t8 = false;
    private boolean t9 = false;
    private boolean t10 = false;

    private List<Student> students = null;
    private Student student = null;
    private StringBuilder data;

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String xName, Attributes attributes) {
        if(xName.equalsIgnoreCase("student")) {
            student = new Student();
            if(students == null) {
                students = new ArrayList<Student>();
            }
        }
        else if (xName.equalsIgnoreCase("Name")) {
            bName = true;
        }
        else if (xName.equalsIgnoreCase("group")) {
            bGroup = true;
        }
        else if (xName.equalsIgnoreCase("firstTerm")) {
            t1 = true;
        }
        else if (xName.equalsIgnoreCase("SecondTerm")) {
            t2 = true;
        }
        else if (xName.equalsIgnoreCase("thirdTerm")) {
            t3 = true;
        }
        else if (xName.equalsIgnoreCase("fourthTerm")) {
            t4 = true;
        }
        else if (xName.equalsIgnoreCase("fifthTerm")) {
            t5 = true;
        }
        else if (xName.equalsIgnoreCase("sixthTerm")) {
            t6 = true;
        }
        else if (xName.equalsIgnoreCase("seventhTerm")) {
            t7 = true;
        }
        else if (xName.equalsIgnoreCase("eighthTerm")) {
            t8 = true;
        }
        else if (xName.equalsIgnoreCase("ninthTerm")) {
            t9 = true;
        }
        else if (xName.equalsIgnoreCase("tenthTerm")) {
            t10 = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String xName) {
        if(bName) {
            student.setName(data.toString());
            bName = false;
        }
        else if (bGroup) {
            student.setGroup(data.toString());
            bGroup = false;
        }
        else if (t1) {
            student.setFirstTerm(Integer.parseInt(data.toString()));
            t1 = false;
        }
        else if (t2) {
            student.setSecondTerm(Integer.parseInt(data.toString()));
            t2 = false;
        }
        else if (t3) {
            student.setThirdTerm(Integer.parseInt(data.toString()));
            t3 = false;
        }
        else if (t4) {
            student.setFourthTerm(Integer.parseInt(data.toString()));
            t4 = false;
        }
        else if (t5) {
            student.setFiveTerm(Integer.parseInt(data.toString()));
            t5 = false;
        }
        else if (t6) {
            student.setSixthTerm(Integer.parseInt(data.toString()));
            t6 = false;
        }
        else if (t7) {
            student.setSeventhTerm(Integer.parseInt(data.toString()));
            t7 = false;
        }
        else if (t8) {
            student.setEighthTerm(Integer.parseInt(data.toString()));
            t8 = false;
        }
        else if (t9) {
            student.setNinthTerm(Integer.parseInt(data.toString()));
            t9 = false;
        }
        else if (t10) {
            student.setTenthTerm(Integer.parseInt(data.toString()));
            t10 = false;
        }

        if (xName.equalsIgnoreCase("Student")) {
            students.add(student);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}