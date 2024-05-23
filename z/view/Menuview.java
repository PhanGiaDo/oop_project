package z.view;

import java.awt.*;
import javax.swing.*;

import z.animation.LinkedListAnimation;
import z.animation.QueueAnimation;
import z.animation.StackAnimation;
import z.controller.Controller;
import z.model.*;

public class Menuview extends JFrame{
    private z.animation.LinkedListAnimation llist_animation = new LinkedListAnimation();
    private z.animation.StackAnimation stack_animation = new StackAnimation();
    private z.animation.QueueAnimation queue_animation = new QueueAnimation();    
    private JToolBar jToolBar;
    private JTextField text;
    private JTextField text2;
    private JLabel label;
    private JLabel label2;
    private JPanel panel;
    private JPopupMenu jPopupMenu;
    private String llist_state = "";
    private String stack_state = "";
    private String queue_state = "";


//     private boolean llist_create;
//     private boolean llist_search;
//     private boolean llist_insert;
//     private boolean llist_remove;
//     private boolean stack_push;
//     private boolean stack_pop;
//     private boolean stack_peek;
//     private boolean queue_enqueue;
//     private boolean queue_dequeue;
//     private boolean queue_peekfront;
//     private boolean queue_peekback;
    
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

    
////////////////////////////////  Get Properties  ////////////////////////////////////////////////////////


    public String getLlistState(){
        return llist_state;
    }
    public String getStackState(){
        return stack_state;
    }
    public String getQueueState(){
        return queue_state;
    }
    public String getText1(){
        return text.getText();
    }
    public String getText2(){
        return text2.getText();
    }


////////////////////////// LINKED LIST /////////////////////////////////////////////

    public void LinkedList_Menuview() {
        Controller ac = new Controller(this);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        this.setLayout(new BorderLayout());

        if (this.jToolBar != null) {
            this.remove(this.jToolBar);
        }
        if (this.stack_animation != null) {
            this.remove(this.stack_animation);
        }
        if (this.queue_animation != null) {
            this.remove(this.queue_animation);
        }

        this.jToolBar = new JToolBar();

        JButton button_insert = new JButton("Insert");
        button_insert.addActionListener(ac);
        button_insert.setFont(font);

        JButton button_search = new JButton("Search");
        button_search.addActionListener(ac);
        button_search.setFont(font);

        JButton button_remove = new JButton("Remove");
        button_remove.addActionListener(ac);
        button_remove.setFont(font);

        JButton button_run = new JButton("Run");
        button_run.addActionListener(ac);
        button_run.setFont(font);

        this.jToolBar.add(button_insert);
        this.jToolBar.add(button_remove);
        this.jToolBar.add(button_search);
        this.jToolBar.add(button_run);

        this.add(this.jToolBar , BorderLayout.NORTH);
        this.revalidate();  
    }

    public void LinkedList_Menuview(String src){
        if (src.equals("Remove")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            this.setLayout(null);

            this.llist_state = "remove";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.label = new JLabel("index_remove (>0) = ");
            this.text = new JTextField();
            this.text.setFont(font);
            this.label.setFont(font);
            
            this.label.setBounds(10, 50, 200, 50);
            this.text.setBounds(210, 50, 50, 50);
            this.add(this.label);
            this.add(this.text);

            this.revalidate();
            this.repaint();
        } else if (src.equals("Insert")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            this.setLayout(null);
            
            this.llist_state = "insert";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }
            this.label = new JLabel("idex_insert (>0) = ");
            this.text = new JTextField();
            this.text.setFont(font);
            this.label.setFont(font);
            this.label.setBounds(10, 50, 180, 50);
            this.text.setBounds(200, 50, 50, 50);
            this.add(this.label);
            this.add(this.text);

            this.label2 = new JLabel("value = ");
            this.text2 = new JTextField();
            this.text2.setFont(font);
            this.label2.setFont(font);
            this.label2.setBounds(10, 100, 120, 50);
            this.text2.setBounds(100, 100, 50, 50);
            this.add(this.label2);
            this.add(this.text2);

            this.revalidate();
            this.repaint();
        } else if (src.equals("Search")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            this.setLayout(null);

            this.llist_state = "search";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.label = new JLabel("value = ");
            this.text = new JTextField();
            this.text.setFont(font);
            this.label.setFont(font);
            
            this.label.setBounds(10, 50, 120, 50);
            this.text.setBounds(100, 50, 50, 50);
            this.add(this.label);
            this.add(this.text);

            this.revalidate();
            this.repaint();
        }
    }
    
    public void LinkedListAnimation(LinkedList linkedList, int index, int value, String src) {
        if (src.equals("insert")) {
            this.llist_animation.LinkedListAnimationInsert(linkedList, index, value);
        } else if (src.equals("remove")) {
            this.llist_animation.LinkedListAnimationRemove(linkedList, index);
        } else if (src.equals("search")) {
            this.llist_animation.LinkedListAnimationSearch(linkedList, value);
        }
        this.llist_animation.setBounds(200, 300, 5000, 5000);
        this.add(this.llist_animation);
        this.repaint();
        this.revalidate();
    }

////////////////////////// STACK /////////////////////////////////////////////


    public void Stack_Menuview() {
        Controller ac = new Controller(this);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        this.setLayout(new BorderLayout());

        if (this.jToolBar != null) {
            this.remove(this.jToolBar);
        }
        if (this.llist_animation != null) {
            this.remove(this.stack_animation);
        }
        if (this.queue_animation != null) {
            this.remove(this.llist_animation);
        }
        this.jToolBar = new JToolBar();

        JButton button_push = new JButton("Push");
        button_push.addActionListener(ac);
        button_push.setFont(font);

        JButton button_pop = new JButton("Pop");
        button_pop.addActionListener(ac);
        button_pop.setFont(font);

        JButton button_peek = new JButton("Peek");
        button_peek.addActionListener(ac);
        button_peek.setFont(font);

        JButton button_run = new JButton("Run");
        button_run.addActionListener(ac);
        button_run.setFont(font);

        this.jToolBar.add(button_push);
        this.jToolBar.add(button_pop);
        this.jToolBar.add(button_peek);
        this.jToolBar.add(button_run);

        this.add(this.jToolBar , BorderLayout.NORTH);
        this.revalidate();  
    }

    public void Stack_Menuview(String src){
        if (src.equals("Push")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            this.setLayout(null);

            this.stack_state = "push";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.label = new JLabel("value = ");
            this.text = new JTextField();
            this.text.setFont(font);
            this.label.setFont(font);
            
            this.label.setBounds(10, 50, 100, 50);
            this.text.setBounds(120, 50, 50, 50);
            this.add(this.label);
            this.add(this.text);

            this.revalidate();
            this.repaint();
        } else if (src.equals("Pop")) {
            this.setLayout(null);
            
            this.stack_state = "pop";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.revalidate();
            this.repaint();
        } else if (src.equals("Peek")) {
            this.setLayout(null);

            this.stack_state = "peek";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }
            this.revalidate();
            this.repaint();
        }
    }

    public void StackAnimation(Stack stack, int value, String src) {
        if (src.equals("push")) {
            this.stack_animation.StackAnimationPush(stack, value);
        } else if (src.equals("pop")) {
            this.stack_animation.StackAnimationPop(stack);
        } else if (src.equals("peek")) {
            this.stack_animation.StackAnimationPeek(stack);
        }
        this.stack_animation.setBounds(250, 150, 5000, 5000);
        this.add(this.stack_animation);
        this.repaint();
        this.revalidate();
    }

////////////////////////// QUEUE /////////////////////////////////////////////

    public void Queue_Menuview() {
        Controller ac = new Controller(this);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        this.setLayout(new BorderLayout());

        if (this.jToolBar != null) {
            this.remove(this.jToolBar);
        }
        if (this.stack_animation != null) {
            this.remove(this.stack_animation);
        }
        if (this.llist_animation != null) {
            this.remove(this.llist_animation);
        }
        this.jToolBar = new JToolBar();

        JButton button_enqueue = new JButton("Enqueue");
        button_enqueue.addActionListener(ac);
        button_enqueue.setFont(font);

        JButton button_dequeue = new JButton("Dequeue");
        button_dequeue.addActionListener(ac);
        button_dequeue.setFont(font);

        JButton button_peekfront = new JButton("Peek_Front");
        button_peekfront.addActionListener(ac);
        button_peekfront.setFont(font);

        JButton button_peekback = new JButton("Peek_Back");
        button_peekback.addActionListener(ac);
        button_peekback.setFont(font);

        JButton button_run = new JButton("Run");
        button_run.addActionListener(ac);
        button_run.setFont(font);

        this.jToolBar.add(button_enqueue);
        this.jToolBar.add(button_dequeue);
        this.jToolBar.add(button_peekfront);
        this.jToolBar.add(button_peekback);
        this.jToolBar.add(button_run);


        this.add(this.jToolBar , BorderLayout.NORTH);
        this.revalidate();  
    }

    public void Queue_Menuview(String src){
        if (src.equals("Enqueue")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            this.setLayout(null);

            this.queue_state = "enqueue";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.label = new JLabel("value = ");
            this.text = new JTextField();
            this.text.setFont(font);
            this.label.setFont(font);
            
            this.label.setBounds(10, 50, 100, 50);
            this.text.setBounds(110, 50, 50, 50);
            this.add(this.label);
            this.add(this.text);

            this.revalidate();
            this.repaint();
        } else if (src.equals("Dequeue")) {
            this.setLayout(null);
            
            this.queue_state = "dequeue";
            
            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.revalidate();
            this.repaint();
        } else if (src.equals("Peek_Front")) {
            this.setLayout(null);

            this.queue_state = "peek_front";
            

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.revalidate();
            this.repaint();
        } else if (src.equals("Peek_Back")) {
            this.setLayout(null);

            this.queue_state = "peek_back";

            if (this.label != null) {
                this.remove(this.label);
                this.remove(this.text);
            }
            if (this.label2 != null) {
                this.remove(this.label2);
                this.remove(this.text2);  
            }

            this.revalidate();
            this.repaint();
        }
    }

    public void QueueAnimation(Queue queue, int value, String src) {
        if (src.equals("Enqueue")) {
            this.queue_animation.QueueAnimationEnqueue(queue, value);
        } else if (src.equals("Dequeue")) {
            this.queue_animation.QueueAnimationDequeue(queue);
        } else if (src.equals("Peek_Front")) {
            this.queue_animation.QueueAnimationPeekFront(queue);
        } else if (src.equals("Peek_Back")) {
            this.queue_animation.QueueAnimationPeekBack(queue);
        }
        this.queue_animation.setBounds(200, 200, 5000, 5000);
        this.add(this.queue_animation);
        this.repaint();
        this.revalidate();
    }
}
