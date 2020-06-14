package com.company;


import com.company.controller.Controller;
import com.company.model.Student;
import com.company.view.Window;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ArrayList<Student>());
        Window window = new Window(controller);
        window.start();

    }
}


