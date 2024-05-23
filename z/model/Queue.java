package z.model;

public class Queue {
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (tail != null) tail.setNext(newNode);;
        tail = newNode;
        if (head == null) head = newNode;
    }

    public void dequeue() {
        if (head == null) return;
        head = head.getNext();
        if (head == null) tail = null;
    }

    public int peek_front() {
        if (head == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return head.getData();
    }

    public int peek_back() {
        if (tail == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return tail.getData();
    }
    
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }











}
