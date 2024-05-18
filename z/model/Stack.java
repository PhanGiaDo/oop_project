package z.model;

import java.awt.*;
import javax.swing.*;

import z.controller.Controller;
import z.view.Menuview;

public class Stack {
    public Node top;

    public Stack() {
        this.top = null;
    }

    public void Stack_Menuview(Menuview menuview) {
        Controller ac = new Controller(menuview);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        menuview.setLayout(new BorderLayout());

        if (menuview.jToolBar != null) {
            menuview.remove(menuview.jToolBar);
        }
        if (menuview.llist_animation != null) {
            menuview.remove(menuview.stack_animation);
        }
        if (menuview.queue_animation != null) {
            menuview.remove(menuview.llist_animation);
        }
        menuview.jToolBar = new JToolBar();

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

        menuview.jToolBar.add(button_push);
        menuview.jToolBar.add(button_pop);
        menuview.jToolBar.add(button_peek);
        menuview.jToolBar.add(button_run);

        menuview.add(menuview.jToolBar , BorderLayout.NORTH);
        menuview.revalidate();  
    }

    public void Stack_Menuview(Menuview menuview, String src){
        if (src.equals("Push")) {
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);

            menuview.stack_push = true;
            menuview.stack_pop = false;
            menuview.stack_peek = false;

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
            menuview.text.setBounds(120, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Pop")) {
            menuview.setLayout(null);
            
            menuview.stack_push = false;
            menuview.stack_pop = true;
            menuview.stack_peek = false;

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
        } else if (src.equals("Peek")) {
            menuview.setLayout(null);

            menuview.stack_push = false;
            menuview.stack_pop = false;
            menuview.stack_peek = true;

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

    public void StackAnimation(Menuview menuview, Stack stack, int value, String src) {
        if (src.equals("push")) {
            menuview.stack_animation.StackAnimationPush(stack, value);
        } else if (src.equals("pop")) {
            menuview.stack_animation.StackAnimationPop(stack);
        } else if (src.equals("peek")) {
            menuview.stack_animation.StackAnimationPeek(stack);
        }
        menuview.stack_animation.setBounds(250, 150, 5000, 5000);
        menuview.add(menuview.stack_animation);
        menuview.repaint();
        menuview.revalidate();

    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            return;
        }
        top = top.next;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        else {
            return top.data;
        }
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
