package z.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import z.animation.*;

import z.model.LinkedList;
import z.model.Queue;
import z.model.Stack;
import z.view.Menuview;

public class Controller implements ActionListener {
    private Menuview menuview;
    private LinkedList linkedList = new LinkedList();
    private Stack stack;
    private Queue queue;
    
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
                if (menuview.llist_create) {
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
                this.stack = new Stack(menuview);
                System.out.println("Stack");
                break;
            case "Queue":
                this.queue = new Queue(menuview);
                System.out.println("Queue");
                break;
            default:
                System.out.println(src);
                break;
        }
    }
}
