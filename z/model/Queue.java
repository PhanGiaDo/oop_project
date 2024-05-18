package z.model;

import java.awt.*;
import javax.swing.*;

import z.controller.Controller;
import z.view.Menuview;

public class Queue {
    public Node head;

    public Queue() {
        this.head = null;
    }

    public void Queue_Menuview(Menuview menuview) {
        Controller ac = new Controller(menuview);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        menuview.setLayout(new BorderLayout());

        if (menuview.jToolBar != null) {
            menuview.remove(menuview.jToolBar);
        }
        if (menuview.stack_animation != null) {
            menuview.remove(menuview.stack_animation);
        }
        if (menuview.llist_animation != null) {
            menuview.remove(menuview.llist_animation);
        }
        menuview.jToolBar = new JToolBar();

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

        menuview.jToolBar.add(button_enqueue);
        menuview.jToolBar.add(button_dequeue);
        menuview.jToolBar.add(button_peekfront);
        menuview.jToolBar.add(button_peekback);
        menuview.jToolBar.add(button_run);


        menuview.add(menuview.jToolBar , BorderLayout.NORTH);
        menuview.revalidate();  
    }

    public void Queue_Menuview(Menuview menuview, String src){
        if (src.equals("Enqueue")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);

            menuview.queue_dequeue = false;
            menuview.queue_enqueue = true;
            menuview.queue_peekfront = false;
            menuview.queue_peekback = false;

            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.label = new JLabel("value = ");
            menuview.text = new JTextField();
            menuview.text.setFont(font);
            menuview.label.setFont(font);
            
            menuview.label.setBounds(10, 50, 100, 50);
            menuview.text.setBounds(110, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Dequeue")) {
            menuview.setLayout(null);
            
            menuview.queue_dequeue = true;
            menuview.queue_enqueue = false;
            menuview.queue_peekfront = false;
            menuview.queue_peekback = false;
            
            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Peek_Front")) {
            menuview.setLayout(null);

            menuview.queue_dequeue = false;
            menuview.queue_enqueue = false;
            menuview.queue_peekfront = true;
            menuview.queue_peekback = false;

            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Peek_Back")) {
            menuview.setLayout(null);

            menuview.queue_dequeue = false;
            menuview.queue_enqueue = false;
            menuview.queue_peekfront = false;
            menuview.queue_peekback = true;

            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.revalidate();
            menuview.repaint();
        }
    }

    public void QueueAnimation(Menuview menuview, Queue queue, int value, String src) {
        if (src.equals("Enqueue")) {
            menuview.queue_animation.QueueAnimationEnqueue(queue, value);
        } else if (src.equals("Dequeue")) {
            menuview.queue_animation.QueueAnimationDequeue(queue);
        } else if (src.equals("Peek_Front")) {
            menuview.queue_animation.QueueAnimationPeekFront(queue);
        } else if (src.equals("Peek_Back")) {
            menuview.queue_animation.QueueAnimationPeekBack(queue);
        }
        menuview.queue_animation.setBounds(200, 200, 5000, 5000);
        menuview.add(menuview.queue_animation);
        menuview.repaint();
        menuview.revalidate();

    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public void dequeue() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int peek_front() {
        if (head == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return head.data;
    }

    public int peek_back() {
        if (head == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p.data;
    }
    
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }











}
