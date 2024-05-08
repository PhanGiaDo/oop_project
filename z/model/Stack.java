package z.model;

import java.awt.*;
import javax.swing.*;

import z.controller.Controller;
import z.view.Menuview;

public class Stack {

    public Stack(Menuview menuview) {
        Controller ac = new Controller(menuview);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        menuview.setLayout(new BorderLayout());

        if (menuview.jToolBar != null) {
            menuview.remove(menuview.jToolBar);
        }
        menuview.jToolBar = new JToolBar();

        JButton button_create = new JButton("S1");
        button_create.addActionListener(ac);
        button_create.setFont(font);

        JButton button_search = new JButton("S2");
        button_search.addActionListener(ac);
        button_search.setFont(font);

        JButton button_insert = new JButton("S3");
        button_insert.addActionListener(ac);
        button_insert.setFont(font);

        JButton button_remove = new JButton("S4");
        button_remove.addActionListener(ac);
        button_remove.setFont(font);

        menuview.jToolBar.add(button_create);
        menuview.jToolBar.add(button_search);
        menuview.jToolBar.add(button_insert);
        menuview.jToolBar.add(button_remove);

        menuview.add(menuview.jToolBar , BorderLayout.NORTH);
        menuview.revalidate();  
    }
}
