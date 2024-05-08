package z.view;

import java.awt.*;
import javax.swing.*;

import z.controller.Controller;

public class Menuview extends JFrame{
    public JToolBar jToolBar;
    public JTextField text;
    public JTextField text2;
    public JLabel label;
    public JLabel label2;
    public JPanel panel;
    public JPopupMenu jPopupMenu;
    public boolean llist_create;
    public boolean llist_search;
    public boolean llist_insert;
    public boolean llist_remove;

    public Menuview() {
//Start
        this.setTitle("OOP Project");
        this.setSize(700, 700);
        Controller ac = new Controller(this);
        Font font = new Font("Time New Roman", Font.BOLD, 30);

        
//MenuBar
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("TYPE");
        JMenuItem jMenuItem_llist = new JMenuItem("Linked List");
        jMenuItem_llist.addActionListener(ac);
        JMenuItem jMenuItem_stack = new JMenuItem("Stack");
        jMenuItem_stack.addActionListener(ac);
        JMenuItem jMenuItem_queue = new JMenuItem("Queue");
        jMenuItem_queue.addActionListener(ac);
        jMenu.add(jMenuItem_llist);
        jMenu.add(jMenuItem_stack);
        jMenu.add(jMenuItem_queue);
        jMenu.addSeparator();
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);   
        
//End
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
