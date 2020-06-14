package com.company.view;

import com.company.controller.Controller;
import com.company.model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTable extends Composite {
    private Table table;
    private Controller controller;
    private int numOfStudentsOnPage = 10;
    private int pageNum = 0;
    private Label pagesIndicatorLabel;

    private List<Student> searchStudentList;

    public StudentTable(Composite parent, int style, Controller controller) {
        super(parent, style);

        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginTop = 20;
        rowLayout.marginBottom = 20;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.spacing = 10;
        this.setLayout(rowLayout);

        table = new Table(this, style);
        table.setHeaderVisible(true);
        String[] titles = {"Student Name", "group Number",
                "First Term", "Second Term", "Third Term", "Forth Term", "Fifth Term",
                "Sixth Term", "Seventh Term", "Eighth Term", "Ninth Term", "Tenth Term",
                "Total amount",
                };
        for (int i = 0; i < titles.length; i++) {
            TableColumn column = new TableColumn(table, SWT.CENTER);
            column.setText(titles[i]);
            table.getColumn(i).pack();
        }
        this.controller = controller;



        Button prev_pageButton = new Button(this, SWT.PUSH);
        prev_pageButton.setText("<");
        prev_pageButton.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                if (pageNum - 1 >= 0) {
                    pageNum--;
                    if (searchStudentList.isEmpty()) {
                        renew_Table();
                    } else renew_Table(searchStudentList);
                }
            }
        });

        Button next_pageButton = new Button(this, SWT.PUSH);
        next_pageButton.setText(">");
        next_pageButton.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                if (searchStudentList.isEmpty()) {
                    if (pageNum + 1 < Math.ceil((double) controller.getAllStudents().size() / numOfStudentsOnPage)) {
                        pageNum++;
                        renew_Table();
                    }
                } else {
                    if (pageNum + 1 < Math.ceil((double) searchStudentList.size() / numOfStudentsOnPage)) {
                        pageNum++;
                        renew_Table(searchStudentList);
                    }
                }
            }
        });



        searchStudentList = new ArrayList<Student>();
        pagesIndicatorLabel = new Label(this, SWT.NONE);
        pagesIndicatorLabel.setText("1/1");

        this.pack();
        table.pack();
        super.pack();
    }

    private void fill_Table(List<Student> students) {
        table.removeAll();
        for (Student student : students) {
            try {
                if (student.getName() == null || student.getGroup() == null)
                    throw new Exception("There is no information available");
            } catch (Exception ex) {
                System.exit(1);
            }

            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, student.getName());
            item.setText(1, student.getGroup());
            item.setText(2, Integer.toString(student.getFirstTerm()));
            item.setText(3, Integer.toString(student.getSecondTerm()));
            item.setText(4, Integer.toString(student.getThirdTerm()));
            item.setText(5, Integer.toString(student.getFourthTerm()));
            item.setText(6, Integer.toString(student.getFiveTerm()));
            item.setText(7, Integer.toString(student.getSixthTerm()));
            item.setText(8, Integer.toString(student.getSeventhTerm()));
            item.setText(9, Integer.toString(student.getEighthTerm()));
            item.setText(10, Integer.toString(student.getNinthTerm()));
            item.setText(11, Integer.toString(student.getTenthTerm()));
            item.setText(12, Integer.toString(student.getTotal()));
        }
    }





    public void renew_Table() {
        List<Student> students = getStudentPage(pageNum, numOfStudentsOnPage, controller.getAllStudents());
        fill_Table(students);
        pagesIndicatorLabel.setText((pageNum + 1) + "/" + (int) Math.ceil((double) controller.getAllStudents().size() / numOfStudentsOnPage));
        table.pack();
        this.pack();
    }


    public void renew_Table(List<Student> studentsList) {
        searchStudentList = studentsList;
        List<Student> students = getStudentPage(pageNum, numOfStudentsOnPage, studentsList);
        fill_Table(students);
        pagesIndicatorLabel.setText((pageNum + 1) + "/" + (int) Math.ceil((double) searchStudentList.size() / numOfStudentsOnPage));
        table.pack();
        this.pack();
        }

    private List<Student> getStudentPage(int index, int numOfStudentsOnPage, List<Student> students) {
        List<List<Student>> pages = calculatePages(numOfStudentsOnPage, students);
        if (!pages.isEmpty()) {
            return pages.get(index);
        } else {
            List<Student> page = new ArrayList<Student>();
            return page;
        }
    }

    private List<List<Student>> calculatePages(int numOfStudentsOnPage, List<Student> students) {
        List<List<Student>> pages = new ArrayList<List<Student>>();
        int numOfPages = (int) Math.ceil((double) students.size() / numOfStudentsOnPage);

        for (int j = 0; j < numOfPages; j++) {
            List<Student> studentPage = new ArrayList<Student>();
            for (int i = numOfStudentsOnPage * j; i < numOfStudentsOnPage * j + numOfStudentsOnPage; i++) {
                try {
                    studentPage.add(students.get(i));
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
            pages.add(studentPage);
        }
        return pages;
    }
}