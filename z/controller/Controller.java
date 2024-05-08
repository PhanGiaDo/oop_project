package z.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import z.animation.LinkedListAnimation;
import z.model.LinkedList;
import z.model.Queue;
import z.model.Stack;
import z.view.Menuview;

public class Controller implements ActionListener {
    private Menuview menuview;
    private LinkedList linkedList;
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
                this.linkedList = new LinkedList();
                this.linkedList = new LinkedList(menuview);
                System.out.println("Linked List");
                break;
            case "Create":
                this.linkedList = new LinkedList(menuview, src);
                System.out.println("Create");
                break;
            case "Search":
                this.linkedList = new LinkedList(menuview, src);
                System.out.println("Search");
                break;    
            case "Insert":
                this.linkedList = new LinkedList(menuview, src);
                System.out.println("Insert");
                break;
            case "Remove":
                this.linkedList = new LinkedList(menuview, src);
                System.out.println("Remove");
                break;
            case "Run":
                if (menuview.llist_create) {
                    System.out.println("create n = " + menuview.text.getText());
                } else if (menuview.llist_search) {
                    System.out.println("search v = " + menuview.text.getText());
                } else if (menuview.llist_insert) {
                    int index = Integer.parseInt(menuview.text.getText());
                    int value = Integer.parseInt(menuview.text2.getText());
                    this.linkedList.LinkedListAnimationInsert(menuview, linkedList, index, value);
                    System.out.println("insert v = " + menuview.text2.getText() + ", index = " + menuview.text.getText());
                } else if (menuview.llist_remove) {
                    System.out.println("remove index " + menuview.text.getText());
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
