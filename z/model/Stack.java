package z.model;

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public Node getTop() {
        return top;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null){
            top = newNode;
            return;
        }
        newNode.setNext(top);
        top = newNode;
    }

    public void pop() {
        if (top == null) return;
        top = top.getNext();
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        else return top.getData();
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

}
