package com.company.loader;

import com.company.model.Student;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Loader {
    public List<Student> load(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            LoaderHandler handler = new LoaderHandler();
            saxParser.parse(new File(filePath), handler);
            return handler.getStudents();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
