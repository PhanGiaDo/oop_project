package z.view;

import javax.swing.*;

import z.animation.LinkedListAnimation;
import z.animation.QueueAnimation;
import z.animation.StackAnimation;
import z.controller.Controller;

public class Menuview extends JFrame{
    public z.animation.LinkedListAnimation llist_animation = new LinkedListAnimation();
    public z.animation.StackAnimation stack_animation = new StackAnimation();
    public z.animation.QueueAnimation queue_animation = new QueueAnimation();    
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
    public boolean stack_push;
    public boolean stack_pop;
    public boolean stack_peek;
    public boolean queue_enqueue;
    public boolean queue_dequeue;
    public boolean queue_peekfront;
    public boolean queue_peekback;
    
    public Menuview() {
//Start
        this.setTitle("OOP Project");
        this.setSize(700, 800);
        Controller ac = new Controller(this);

//Set Icon
        ImageIcon icon1 = new ImageIcon("z\\icon\\rabbit.png");
        ImageIcon icon2 = new ImageIcon("z\\icon\\strawberry.png");     
        ImageIcon icon3 = new ImageIcon("z\\icon\\chocolate_bar.png");       
        ImageIcon icon4 = new ImageIcon("z\\icon\\ledger.png");       
        ImageIcon icon5 = new ImageIcon("z\\icon\\slightly_smiling_face.png");       
        ImageIcon icon6 = new ImageIcon("z\\icon\\man-running.png");

//MenuBar
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu_type = new JMenu("Data Structures");
        JMenu jMenu_help = new JMenu("Help");
        JMenu jMenu_quit = new JMenu("Quit");

        JMenuItem jMenuItem_llist = new JMenuItem("Linked List", icon1);
        jMenuItem_llist.addActionListener(ac);
        JMenuItem jMenuItem_stack = new JMenuItem("Stack", icon2);
        jMenuItem_stack.addActionListener(ac);
        JMenuItem jMenuItem_queue = new JMenuItem("Queue", icon3);
        jMenuItem_queue.addActionListener(ac);
        jMenu_type.add(jMenuItem_llist);
        jMenu_type.addSeparator();
        jMenu_type.add(jMenuItem_stack);
        jMenu_type.addSeparator();
        jMenu_type.add(jMenuItem_queue);
        jMenu_type.addSeparator();

        JMenuItem jMenuItem_usage = new JMenuItem("usage", icon4);
        jMenuItem_usage.addActionListener(ac);

        JMenuItem jMenuItem_aim = new JMenuItem("aim", icon5);
        jMenuItem_aim.addActionListener(ac);

        jMenu_help.add(jMenuItem_usage);
        jMenu_help.addSeparator();
        jMenu_help.add(jMenuItem_aim);

        JMenuItem jMenuItem_quit = new JMenuItem("quit", icon6);
        jMenuItem_quit.addActionListener(ac);
        jMenu_quit.add(jMenuItem_quit);

        jMenuBar.add(jMenu_type);
        jMenuBar.add(jMenu_help);
        jMenuBar.add(jMenu_quit);
        this.setJMenuBar(jMenuBar);  
        
//End
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
