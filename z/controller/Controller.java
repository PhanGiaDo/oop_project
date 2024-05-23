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
                this.menuview.LinkedList_Menuview();
                System.out.println("Linked List");
                break;
            case "Create":
                this.menuview.LinkedList_Menuview(src);
                System.out.println("Create");
                break;
            case "Search":
                this.menuview.LinkedList_Menuview(src);
                System.out.println("Search");
                break;    
            case "Insert":
                this.menuview.LinkedList_Menuview(src);
                System.out.println("Insert");
                break;
            case "Remove":
                this.menuview.LinkedList_Menuview(src);
                System.out.println("Remove");
                break;
            case "Run":
                if (menuview.getQueueState().equals("dequeue")) {
                    this.menuview.QueueAnimation(queue, 1, "Dequeue");
                    System.out.println("Dequeue");
                } else if (menuview.getQueueState().equals("enqueue")) {
                    int value = Integer.parseInt(menuview.getText1());
                    this.menuview.QueueAnimation(queue, value, "Enqueue");
                    System.out.println("Enqueue value = " + value);
                } else if (menuview.getQueueState().equals("peek_back")) {
                    this.menuview.QueueAnimation(queue, 1, "Peek_Back");
                    System.out.println("Peek Back");
                } else if (menuview.getQueueState().equals("peek_front")) {
                    this.menuview.QueueAnimation(queue, 1, "Peek_Front");
                    System.out.println("Peek Front");
                } else if (menuview.getStackState().equals("push")) {
                    int value = Integer.parseInt(menuview.getText1());
                    this.menuview.StackAnimation(stack, value, "push");
                    System.out.println("push value = " + value);
                } else if (menuview.getStackState().equals("pop")) {
                    this.menuview.StackAnimation(stack, 1, "pop");
                    System.out.println("pop");
                } else if (menuview.getStackState().equals("peek")) {
                    this.menuview.StackAnimation(stack, 1, "peek");
                    System.out.println("peek");
                } else if (menuview.getLlistState().equals("search")) {
                    int value = Integer.parseInt(menuview.getText1());
                    this.menuview.LinkedListAnimation(linkedList, 1, value, "search");
                    System.out.println("search v = " + value);
                } else if (menuview.getLlistState().equals("insert")) {
                    int index = Integer.parseInt(menuview.getText1());
                    int value = Integer.parseInt(menuview.getText2());
                    this.menuview.LinkedListAnimation(linkedList, index, value, "insert");
                    System.out.println("insert v = " + value + ", index = " + index);
                } else if (menuview.getLlistState().equals("remove")) {
                    int index = Integer.parseInt(menuview.getText1());
                    this.menuview.LinkedListAnimation(linkedList, index, 1, "remove");
                    System.out.println("remove index " + index);
                }
                break;
            case "Stack":
                this.menuview.Stack_Menuview();
                System.out.println("Stack");
                break;
            case "Push":
                this.menuview.Stack_Menuview(src);
                System.out.println("Push");
                break;
            case "Pop":
                this.menuview.Stack_Menuview(src);
                System.out.println("Pop");
                break;
            case "Peek":
                this.menuview.Stack_Menuview(src);
                System.out.println("Peek");
                break;
            case "Queue":
                this.menuview.Queue_Menuview();
                System.out.println("Queue");
                break;
            case "Enqueue":
                this.menuview.Queue_Menuview(src);
                System.out.println("Enqueue");
                break;
            case "Dequeue":
                this.menuview.Queue_Menuview(src);
                System.out.println("Dequeue");
                break;
            case "Peek_Front":
                this.menuview.Queue_Menuview(src);
                System.out.println("Peek_Front");
                break;
            case "Peek_Back":
                this.menuview.Queue_Menuview(src);
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
