package z.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import z.model.*;

import z.view.Menuview;

public class Controller implements ActionListener {
    private Menuview menuview;
    private LinkedList linkedList = new LinkedList();
    private Stack stack = new Stack();
    private Queue queue = new Queue();
    
    public Controller(Menuview menuview) {
        this.menuview = menuview;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        switch (src) {
            case "Linked List":
                this.linkedList.LinkedList_Menuview(menuview);
                System.out.println("Linked List");
                break;
            case "Create":
                this.linkedList.LinkedList_Menuview(menuview, src);
                System.out.println("Create");
                break;
            case "Search":
                this.linkedList.LinkedList_Menuview(menuview, src);
                System.out.println("Search");
                break;    
            case "Insert":
                this.linkedList.LinkedList_Menuview(menuview, src);
                System.out.println("Insert");
                break;
            case "Remove":
                this.linkedList.LinkedList_Menuview(menuview, src);
                System.out.println("Remove");
                break;
            case "Run":
                if (menuview.queue_dequeue) {
                    this.queue.QueueAnimation(menuview, queue, 1, "Dequeue");
                    System.out.println("Dequeue");
                } else if (menuview.queue_enqueue) {
                    int value = Integer.parseInt(menuview.text.getText());
                    this.queue.QueueAnimation(menuview, queue, value, "Enqueue");
                    System.out.println("Enqueue value = " + value);
                } else if (menuview.queue_peekback) {
                    this.queue.QueueAnimation(menuview, queue, 1, "Peek_Back");
                    System.out.println("Peek Back");
                } else if (menuview.queue_peekfront) {
                    this.queue.QueueAnimation(menuview, queue, 1, "Peek_Front");
                    System.out.println("Peek Front");
                } else if (menuview.stack_push) {
                    int value = Integer.parseInt(menuview.text.getText());
                    this.stack.StackAnimation(menuview, stack, value, "push");
                    System.out.println("push value = " + value);
                } else if (menuview.stack_pop) {
                    this.stack.StackAnimation(menuview, stack, 1, "pop");
                    System.out.println("pop");
                } else if (menuview.stack_peek) {
                    this.stack.StackAnimation(menuview, stack, 1, "peek");
                    System.out.println("peek");
                } else if (menuview.llist_create) {
                    System.out.println("create n = " + menuview.text.getText());
                } else if (menuview.llist_search) {
                    int value = Integer.parseInt(menuview.text.getText());
                    this.linkedList.LinkedListAnimation(menuview, linkedList, 1, value, "search");
                    System.out.println("search v = " + value);
                } else if (menuview.llist_insert) {
                    int index = Integer.parseInt(menuview.text.getText());
                    int value = Integer.parseInt(menuview.text2.getText());
                    this.linkedList.LinkedListAnimation(menuview, linkedList, index, value, "insert");
                    System.out.println("insert v = " + value + ", index = " + index);
                } else if (menuview.llist_remove) {
                    int index = Integer.parseInt(menuview.text.getText());
                    this.linkedList.LinkedListAnimation(menuview, linkedList, index, 1, "remove");
                    System.out.println("remove index " + index);
                }
                break;
            case "Stack":
                this.stack.Stack_Menuview(menuview);
                System.out.println("Stack");
                break;
            case "Push":
                this.stack.Stack_Menuview(menuview, src);
                System.out.println("Push");
                break;
            case "Pop":
                this.stack.Stack_Menuview(menuview, src);
                System.out.println("Pop");
                break;
            case "Peek":
                this.stack.Stack_Menuview(menuview, src);
                System.out.println("Peek");
                break;
            case "Queue":
                this.queue.Queue_Menuview(menuview);
                System.out.println("Queue");
                break;
            case "Enqueue":
                this.queue.Queue_Menuview(menuview, src);
                System.out.println("Enqueue");
                break;
            case "Dequeue":
                this.queue.Queue_Menuview(menuview, src);
                System.out.println("Dequeue");
                break;
            case "Peek_Front":
                this.queue.Queue_Menuview(menuview, src);
                System.out.println("Peek_Front");
                break;
            case "Peek_Back":
                this.queue.Queue_Menuview(menuview, src);
                System.out.println("Peek_Back");
                break;
            case "quit":
                int response = JOptionPane.showConfirmDialog(
                        this.menuview,
                        "Are you sure you want to quit?",
                        "Quit Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon("z\\icon\\question.png")
                );
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
            case "usage":
                try {
                    Runtime.getRuntime().exec(new String[] { "notepad.exe", "z\\help\\usage.txt" });
                } catch (Exception a) {
                    a.printStackTrace();
                }
                break;
            case "aim":
                try {
                    Runtime.getRuntime().exec(new String[] { "notepad.exe", "z\\help\\aim.txt" });
                } catch (Exception a) {
                    a.printStackTrace();
                }
                break;
            default:
                System.out.println(src);
                break;
        }
    }
}
