public class HashSet {
    private static class Node{
        Object data;
        Node next;
        Node(Object data){
            this.data=data;
            this.next=null;
        }
        Node(Object data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node[] arr;
    private int count;
    HashSet(){
        arr=new Node[100];
        count=0;
    }
    public int size(){
        return count;
    }
    public boolean add(Object el){
        if(el==null){
            el="null";
        }
        int index = Math.abs(el.hashCode())%arr.length;
        Node curr = arr[index];

        if(curr==null){
            arr[index]=new Node(el);
            count++;
            return true;
        }
        Node front=curr;
        Node prev=null;
        while(front!=null){
            if(front.data.equals(el)){
                return false;
            }
            prev=front;
            front = front.next;
        }
        prev.next=new Node(el);
        count++;
        return true;
    }
    public boolean contains(Object el){
        int index = Math.abs(el.hashCode())% arr.length;

        Node curr = arr[index];
        while(curr!=null){
            if(curr.data.equals(el)){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }
    public boolean remove(Object el){
        int index = Math.abs(el.hashCode())% arr.length;

        Node curr = arr[index];
        Node prev = null;
        while(curr!=null){
            if(curr.data.equals(el)){
                if(prev==null){
                    arr[index]=arr[index].next;
                    count--;
                    return true;
                }
                prev.next=prev.next.next;
                count--;
                return true;
            }
            prev=curr;
            curr=curr.next;
        }
        return false;
    }
    public void display(){
        for(int i=0;i<arr.length;i++){
            Node curr=arr[i];
            while(curr!=null){
                System.out.println(curr.data);
                curr=curr.next;
            }
        }
    }

    public static void main(String[] args) {
        HashSet set = new HashSet();

        // add elements
        System.out.println(set.add(10));   // true
        System.out.println(set.add(20));   // true
        System.out.println(set.add(30));   // true
        System.out.println(set.add(20));   // false (duplicate)
        System.out.println(set.add("A"));  // true
        System.out.println(set.add("B"));  // true

        // size
        System.out.println("Size: " + set.size()); // 5

        // contains
        System.out.println(set.contains(10)); // true
        System.out.println(set.contains(40)); // false

        // remove
        System.out.println(set.remove(20)); // true
        System.out.println(set.remove(50)); // false

        // size after removal
        System.out.println("Size after remove: " + set.size());

        // display buckets
        System.out.println("HashSet contents:");
        set.display();
    }
}
