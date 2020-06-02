package com.company.view;

import com.company.controller.Controller;
import com.company.listener.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Window {
    private Controller controller;
    private StudentTable table;
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public Window(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        shell.setText("Student Table");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 20;
        rowLayout.marginBottom = 20;
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 10;
        rowLayout.spacing = 10;
        shell.setLayout(rowLayout);

        Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("&File");

        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);

        MenuItem open_Item = new MenuItem(fileMenu, SWT.PUSH);
        open_Item.setText("Открыть");


        LoadListener loadListener = new LoadListener(shell, this, controller);
        open_Item.addListener(SWT.Selection, loadListener);

        MenuItem save_Item = new MenuItem(fileMenu, SWT.PUSH);
        save_Item.setText("Сохранить");

        SaveListener saveListener = new SaveListener(shell, controller);
        save_Item.addListener(SWT.Selection, saveListener);


        MenuItem exit_Item = new MenuItem(fileMenu, SWT.PUSH);
        exit_Item.setText("Выход");
        shell.setMenuBar(menuBar);

        Listener exitListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                System.exit(1);
            }
        };
        exit_Item.addListener(SWT.Selection , exitListener);


        shell.setMenuBar(menuBar);
        Composite  group = new Composite (shell, SWT.HORIZONTAL);
        group.setLayout(new RowLayout(SWT.HORIZONTAL));



        Button addButton = new Button(group, SWT.PUSH);
        addButton.setText("Добавление");
        addButton.setLayoutData(new RowData(150, 40));
        AddListener addListener = new AddListener(shell, controller, this);
        addButton.addListener(SWT.MouseDown, addListener);

        Button deleteButton = new Button(group, SWT.PUSH);
        deleteButton.setText("Удаление");
        deleteButton.setLayoutData(new RowData(150, 40));
        DeleteListener deleteListener = new DeleteListener(shell, controller, this);
        deleteButton.addListener(SWT.MouseDown, deleteListener);

        Button searchButton = new Button(group, SWT.PUSH);
        searchButton.setText("Поиск");
        searchButton.setLayoutData(new RowData(80, 40));
        SearchListener searchListener = new SearchListener(shell, controller);
        searchButton.addListener(SWT.MouseDown, searchListener);


        table = new StudentTable(shell, SWT.NONE, controller);

        shell.pack();
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
    }

    public void renew_Table() {
        table.renew_Table();
    }
}