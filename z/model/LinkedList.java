package z.model;

import java.awt.*;
import javax.swing.*;

import z.animation.*;
import z.controller.Controller;
import z.view.Menuview;
import z.model.Node;

public class LinkedList {
    public Node head;
    private Menuview menuview;
    private z.animation.LinkedListAnimation llist_animation = new LinkedListAnimation();



    public LinkedList() {
        this.head = null;
    }

    public void LinkedList_Menuview(Menuview menuview) {
        Controller ac = new Controller(menuview);
        Font font = new Font("Time New Roman", Font.BOLD, 15);
        menuview.setLayout(new BorderLayout());

        if (menuview.jToolBar != null) {
            menuview.remove(menuview.jToolBar);
        }
        menuview.jToolBar = new JToolBar();

        JButton button_create = new JButton("Create");
        button_create.addActionListener(ac);
        button_create.setFont(font);

        JButton button_search = new JButton("Search");
        button_search.addActionListener(ac);
        button_search.setFont(font);

        JButton button_insert = new JButton("Insert");
        button_insert.addActionListener(ac);
        button_insert.setFont(font);

        JButton button_remove = new JButton("Remove");
        button_remove.addActionListener(ac);
        button_remove.setFont(font);

        JButton button_run = new JButton("Run");
        button_run.addActionListener(ac);
        button_run.setFont(font);

        menuview.jToolBar.add(button_create);
        menuview.jToolBar.add(button_search);
        menuview.jToolBar.add(button_insert);
        menuview.jToolBar.add(button_remove);
        menuview.jToolBar.add(button_run);


        menuview.add(menuview.jToolBar , BorderLayout.NORTH);
        menuview.revalidate();  
    }

    public void LinkedList_Menuview(Menuview menuview, String src){
        if (src.equals("Remove")) {
            //Controller ac = new Controller(menuview);
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);

            menuview.llist_create = false;
            menuview.llist_search = false;
            menuview.llist_insert = false;
            menuview.llist_remove = true;


            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.label = new JLabel("index_remove (>0) = ");
            menuview.text = new JTextField();
            menuview.text.setFont(font);
            menuview.label.setFont(font);
            
            menuview.label.setBounds(10, 50, 200, 50);
            menuview.text.setBounds(210, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Insert")) {
            //Controller ac = new Controller(menuview);
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);
            
            menuview.llist_create = false;
            menuview.llist_search = false;
            menuview.llist_insert = true;
            menuview.llist_remove = false;

            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }
            menuview.label = new JLabel("idex_insert (>0) = ");
            menuview.text = new JTextField();
            menuview.text.setFont(font);
            menuview.label.setFont(font);
            menuview.label.setBounds(10, 50, 180, 50);
            menuview.text.setBounds(200, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.label2 = new JLabel("value = ");
            menuview.text2 = new JTextField();
            menuview.text2.setFont(font);
            menuview.label2.setFont(font);
            menuview.label2.setBounds(10, 100, 120, 50);
            menuview.text2.setBounds(100, 100, 50, 50);
            menuview.add(menuview.label2);
            menuview.add(menuview.text2);

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Search")) {
            //Controller ac = new Controller(menuview);
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);

            menuview.llist_create = false;
            menuview.llist_search = true;
            menuview.llist_insert = false;
            menuview.llist_remove = false;

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
            
            menuview.label.setBounds(10, 50, 120, 50);
            menuview.text.setBounds(100, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.revalidate();
            menuview.repaint();
        } else if (src.equals("Create")) {
            //Controller ac = new Controller(menuview);
            Font font = new Font("Time New Roman", Font.BOLD, 20);
            menuview.setLayout(null);

            menuview.llist_create = true;
            menuview.llist_search = false;
            menuview.llist_insert = false;
            menuview.llist_remove = false;

            if (menuview.label != null) {
                menuview.remove(menuview.label);
                menuview.remove(menuview.text);
            }
            if (menuview.label2 != null) {
                menuview.remove(menuview.label2);
                menuview.remove(menuview.text2);  
            }

            menuview.label = new JLabel("number of elements = ");
            menuview.text = new JTextField();
            menuview.text.setFont(font);
            menuview.label.setFont(font);
            
            menuview.label.setBounds(10, 50, 220, 50);
            menuview.text.setBounds(240, 50, 50, 50);
            menuview.add(menuview.label);
            menuview.add(menuview.text);

            menuview.revalidate();
            menuview.repaint();
        }
    }
    public void LinkedListAnimation(Menuview menuview, LinkedList linkedList, int index, int value, String src) {
        if (src.equals("insert")) {
            this.llist_animation.LinkedListAnimationInsert(linkedList, index, value);
        } else if (src.equals("remove")) {
            this.llist_animation.LinkedListAnimationRemove(linkedList, index);
        } else if (src.equals("search")) {
            this.llist_animation.LinkedListAnimationSearch(linkedList, value);
        }
        this.llist_animation.setBounds(200, 300, 5000, 5000);
        menuview.add(this.llist_animation);
        menuview.repaint();
        menuview.revalidate();
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertMid(int data, int index) {
        if (index < 1) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 1) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentIndex = 1;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }


    public void remove(int index) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (index < 1) {
            System.out.println("Invalid index. Cannot delete.");
            return;
        }

        if (index == 1) {
            head = head.next; // Xóa node đầu danh sách
            return;
        }

       
        Node p = head;
        int currentIndex = 1;

        while ((p.next).next != null && currentIndex != index - 1) {
            p = p.next;
            currentIndex++;
        }

        if (currentIndex == index - 1) {
            p.next = (p.next).next;
            return;
        }
        
        System.out.println("Index out of bounds. Cannot delete.");
        return;
    }

    public int find(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printList() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}