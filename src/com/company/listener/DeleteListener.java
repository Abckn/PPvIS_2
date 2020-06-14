package com.company.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import com.company.controller.Controller;
import com.company.model.Student;
import com.company.view.Window;


import java.util.ArrayList;
import java.util.List;

public class DeleteListener implements Listener {

    private Controller controller;
    private Window window;
    private Shell parent;

    public DeleteListener(Shell parent, Controller controller, Window window) {
        this.parent = parent;
        this.controller = controller;
        this.window = window;
    }

    @Override
    public void handleEvent(Event e) {
        Shell child = new Shell(parent, SWT.SHELL_TRIM | SWT.RESIZE);
        child.setText("Deletion...");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 20;
        rowLayout.marginBottom = 20;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.spacing = 10;
        child.setLayout(rowLayout);

        Label nameLabel = new Label(child, SWT.NONE);
        nameLabel.setText("Введите имя студента:");

        Text nameText = new Text(child, SWT.NONE);
        nameText.setLayoutData(new RowData(300, 30));

        Button nameSearchCheck = new Button(child, SWT.CHECK);
        nameSearchCheck.setText("Удалить по имени");

        Label groupLabel = new Label(child, SWT.NONE);
        groupLabel.setText("Введите группу:");

        Text groupText = new Text(child, SWT.NONE);
        groupText.setLayoutData(new RowData(300, 30));

        Button groupSearchCheck = new Button(child, SWT.CHECK);
        groupSearchCheck.setText("Удалить по группе");

        Label totalWork = new Label(child, SWT.NONE);
        totalWork.setText("Верхняя граница(общее число работы)\n");

        Text totalWorkText = new Text(child, SWT.NONE);
        totalWorkText.setLayoutData(new RowData(300, 30));

        Label totalMinWork = new Label(child, SWT.NONE);
        totalMinWork.setText("Нижняя граница(общее число работы)\n");

        Text totalMinWorkText = new Text(child, SWT.NONE);
        totalMinWorkText.setLayoutData(new RowData(300, 30));

        Button totalMinWorkButton = new Button(child, SWT.CHECK);
        totalMinWorkButton.setText("Удаление по верхней и нижней границу\n");

        Button deleteButton = new Button(child, SWT.NONE);
        deleteButton.setText("Удалить");

        Listener proceedListener = new Listener() {
            @Override
            public void handleEvent(Event e) {

                boolean chek = true;
                List<Student> students = new ArrayList<>();

                if(nameSearchCheck.getSelection() && totalMinWorkButton.getSelection() && chek){
                    chek = false;
                    String group = groupText.getText();
                    String upperper_Bounder = totalWorkText.getText();
                    String lowerer_Bounder = totalMinWorkText.getText();
                    students = controller.find_in_borders(group,lowerer_Bounder,upperper_Bounder, controller.getAllStudents());
                }

                if (groupSearchCheck.getSelection()) {
                    chek = false;
                    String group = groupText.getText();
                    students.addAll(controller.find_group(group, controller.getAllStudents()));
                }


                if (nameSearchCheck.getSelection() && chek) {
                    chek = false;
                    String name = nameText.getText();
                    students = controller.find_Name(name, controller.getAllStudents());
                }

                if(totalMinWorkButton.getSelection() && chek){
                    chek = false;
                    String upperper_Bounder = totalWorkText.getText();
                    String lowerer_Bounder = totalMinWorkText.getText();
                    students.addAll(controller.find_total(lowerer_Bounder,upperper_Bounder, controller.getAllStudents()));

                }
                Shell dialog = new Shell(child);
                dialog.setText("Message");
                dialog.setLayout(new FillLayout());
                Label resultLabel = new Label(dialog, SWT.NONE);
                if (students.size() != 0) {
                    controller.deleteStudents(students);
                    window.renew_Table();
                    resultLabel.setText(students.size() + " students were deleted.");
                } else resultLabel.setText("There's no such students.");
                dialog.pack();
                dialog.open();
            }

        };
        deleteButton.addListener(SWT.MouseDown, proceedListener);
        child.pack();
        child.open();
    }
}
