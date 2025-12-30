// Queue using ArrayList

import java.util.ArrayList;
public class Queue {
    private ArrayList<Integer> list;
    public Queue(){
        list = new ArrayList<>();
    }
    public int peek(){
        if (list.size() == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        return list.get(0);
    }
    public int pop(){
        if (list.size() == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        return list.remove(0);
    }
    public int size(){
        return list.size();
    }
    public void push(int el){
        list.add(el);
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
    public static void main(String[] args) {

        Queue q = new Queue();

        // Enqueue elements
        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Queue size: " + q.size()); // 3
        System.out.println("Front element: " + q.peek()); // 10

        // Dequeue elements
        System.out.println("Removed: " + q.pop()); // 10
        System.out.println("Removed: " + q.pop()); // 20

        // Current state
        System.out.println("Front element now: " + q.peek()); // 30
        System.out.println("Queue size now: " + q.size()); // 1

        // Check empty
        System.out.println("Is queue empty? " + q.isEmpty()); // false

        // Remove last element
        System.out.println("Removed: " + q.pop()); // 30
        System.out.println("Is queue empty now? " + q.isEmpty()); // true
    }
}
