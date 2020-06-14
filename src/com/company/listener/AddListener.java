package com.company.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.company.controller.Controller;
import com.company.view.Window;

public class AddListener implements Listener {

    private Controller controller;
    private Window window;
    private Shell parent;

    public AddListener(Shell parent, Controller controller, Window window) {
        this.parent = parent;
        this.controller = controller;
        this.window = window;
    }

    @Override
    public void handleEvent(Event e) {
        Shell child = new Shell(parent);
        child.setText("Добавление");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 20;
        rowLayout.marginBottom = 20;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.spacing = 10;
        child.setLayout(rowLayout);

        Label studentNameLabel = new Label(child, SWT.NONE);
        studentNameLabel.setText("Введите имя:");

        Text studentNameText = new Text(child, SWT.NONE);
        studentNameText.setLayoutData(new RowData(300, 30));

        Label group = new Label(child, SWT.NONE);
        group.setText("Введите группу:");

        Text groupText = new Text(child, SWT.NONE);
        groupText.setLayoutData(new RowData(300, 30));

        Label first = new Label(child, SWT.NONE);
        first.setText("Первый семестр:");

        Text firstText = new Text(child, SWT.NONE);
        firstText.setLayoutData(new RowData(300, 30));

        Label second = new Label(child, SWT.NONE);
        second.setText("Второй семестр:");

        Text secondText = new Text(child, SWT.NONE);
        secondText.setLayoutData(new RowData(300, 30));

        Label third = new Label(child, SWT.NONE);
        third.setText("Третий семестр:");

        Text thirdText = new Text(child, SWT.NONE);
        thirdText.setLayoutData(new RowData(300, 30));

        Label fourth = new Label(child, SWT.NONE);
        fourth.setText("Четвертый семестр:");

        Text fourthText = new Text(child, SWT.NONE);
        fourthText.setLayoutData(new RowData(300, 30));

        Label five = new Label(child, SWT.NONE);
        five.setText("Пятый семестр:");

        Text fiveText = new Text(child, SWT.NONE);
        fiveText.setLayoutData(new RowData(300, 30));

        Label six = new Label(child, SWT.NONE);
        six.setText("Шестой семестр:");

        Text sixText = new Text(child, SWT.NONE);
        sixText.setLayoutData(new RowData(300, 30));

        Label seventh = new Label(child, SWT.NONE);
        seventh.setText("Седьмой семестр:");

        Text seventhText = new Text(child, SWT.NONE);
        seventhText.setLayoutData(new RowData(300, 30));

        Label eighth = new Label(child, SWT.NONE);
        eighth.setText("Восьмой семестр:");

        Text eighthText = new Text(child, SWT.NONE);
        eighthText.setLayoutData(new RowData(300, 30));

        Label ninth = new Label(child, SWT.NONE);
        ninth.setText("Девятый семестр:");

        Text ninthText = new Text(child, SWT.NONE);
        ninthText.setLayoutData(new RowData(300, 30));

        Label tenth = new Label(child, SWT.NONE);
        tenth.setText("Дсятый семестр:");

        Text tenthText = new Text(child, SWT.NONE);
        tenthText.setLayoutData(new RowData(300, 30));

        Button proceedButton = new Button(child, SWT.PUSH);
        proceedButton.setText("Добавить");
        proceedButton.setLayoutData(new RowData(200, 30));

        Listener proceedListener = new Listener() {

            @Override
            public void handleEvent(Event arg0) {

                String stName = studentNameText.getText();
                String stgroup = groupText.getText();
                int first = Integer.parseInt(firstText.getText());
                int second = Integer.parseInt(secondText.getText());
                int three = Integer.parseInt(thirdText.getText());
                int fourth = Integer.parseInt(fourthText.getText());
                int five = Integer.parseInt(fiveText.getText());
                int six = Integer.parseInt(sixText.getText());
                int seven = Integer.parseInt(seventhText.getText());
                int eight = Integer.parseInt(eighthText.getText());
                int nine = Integer.parseInt(ninthText.getText());
                int ten = Integer.parseInt(tenthText.getText());
                int result = first + second + three + fourth + five + six + seven + eight + nine + ten;

                controller.addStudent(stName, stgroup, first, second, three, fourth, five, six, seven, eight, nine, ten, result);
                window.renew_Table();
                child.dispose();
            }

        };
        proceedButton.addListener(SWT.MouseDown, proceedListener);
        child.pack();
        child.open();
    }
}
