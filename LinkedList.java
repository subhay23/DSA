//Linked List Implementation

public class LinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int count;

    LinkedList() {
        head = null;
        count = 0;
    }

    public void addLast(int el) {
        Node newNode = new Node(el);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
    }

    public void addfirst(int el) {
        Node newNode = new Node(el);

        newNode.next = head;
        head = newNode;
        count++;
    }

    public void addAt(int index, int el) {
        Node newNode = new Node(el);
        if (index < 0 || index > count) {
            throw new RuntimeException("adding at more index");
        }
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            count++;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        count++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("Null pointer");
        }
        head = head.next;
        count--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new RuntimeException("Null pointer");
        }
        if (index == 0) {
            head = head.next;
            count--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        count--;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new RuntimeException("Null pointer");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return count;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void clear() {
        head = null;
        count = 0;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Add elements
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display();     // 10->20->30->null
        System.out.println();
        // Add at beginning
        list.addfirst(5);
        list.display();     // 5->10->20->30->null

        System.out.println();
        // Add at index
        list.addAt(2, 15);
        list.display();     // 5->10->15->20->30->null

        System.out.println();
        // Remove first
        list.removeFirst();
        list.display();     // 10->15->20->30->null

        System.out.println();
        // Remove at index
        list.removeAt(2);
        list.display();     // 10->15->30->null

        System.out.println();

        // Get element
        System.out.println("Element at index 1: " + list.get(1)); // 15

        // Size
        System.out.println("Size: " + list.size()); // 3

        // Clear list
        list.clear();
        list.display();     // null
        System.out.println("Size after clear: " + list.size()); // 0
    }
}