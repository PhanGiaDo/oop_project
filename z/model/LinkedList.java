package z.model;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;
        while (p.getNext() != null) p = p.getNext();
        p.setNext(newNode);
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
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
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
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
            head = head.getNext();
            return;
        }
  
        Node p = head;
        int currentIndex = 1;

        while ((p.getNext()).getNext() != null && currentIndex != index - 1) {
            p = p.getNext();
            currentIndex++;
        }

        if (currentIndex == index - 1) {
            p.setNext((p.getNext()).getNext());
            return;
        }
        
        System.out.println("Index out of bounds. Cannot delete.");
        return;
    }

    public int find(int value) {
        Node current = head;
        int index = 1;
        while (current != null) {
            if (current.getData() == value) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

}