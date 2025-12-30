// Stack using ArrayList

import java.util.ArrayList;
public class Stack {
    private ArrayList<Integer> list;
    public Stack(){
        list=new ArrayList<Integer>();
    }
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size()-1);
    }
    public void push(int ele){
        list.add(ele);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
       return list.remove(list.size()-1);
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size()); // 3
        System.out.println("Top element (peek): " + stack.peek()); // 30

        // Pop elements
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        // Check current state
        System.out.println("Top element now: " + stack.peek()); // 10
        System.out.println("Stack size now: " + stack.size()); // 1

        // Check empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Pop last element
        System.out.println("Popped: " + stack.pop()); // 10

        System.out.println("Is stack empty now? " + stack.isEmpty()); // true
    }
}
