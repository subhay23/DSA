// ArrayList Using Array[]

public class ArrayList {
    private int[] arr;
    private int count;
    public ArrayList(){
        this.arr = new int[10];
        this.count=0;
    }
    public void add(int el){
        if(arr.length==count){
            resize();
        }
        int l = count;
        arr[l]=el;
        count++;
    }
    public void add(int index,int el){
        if(arr.length==count){
            resize();
        }
        if(index<0 || index > count){
            throw new ArrayIndexOutOfBoundsException("Array Index out of Bound");
        }
        for(int i=count-1;i>=index;i--){
            arr[i+1]=arr[i];
        }
        arr[index]=el;
        count++;
    }
    public void remove(int index){
        if(index<0 || index>= count){
            throw new ArrayIndexOutOfBoundsException("Array Index out of Bound");
        }
        for(int i=index+1;i<count;i++){
            arr[i-1] = arr[i];
        }
        count--;
    }
    public int get(int index){
        if(index < 0 || index >= count){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }
    public void set(int index,int el){
        if(index < 0 || index >= count){
            throw new ArrayIndexOutOfBoundsException("Array Out of Bound");
        }
        arr[index]=el;
    }
    public int size(){
        return count;
    }
    public void resize(){
        int[] temp = new int[arr.length*2];
        for(int i=0;i<count;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }
    public String toString(){
        if(size()==0)return"[]";
        String str = "[" + arr[0];
        for(int i=1;i<size();i++){
            str+=","+arr[i];
        }
        str+="]";
        return str;
    }
    public void clear(){
        arr=new int[10];
        count=0;
    }

    public static void main(String[] args) {
        // Create ArrayList
        ArrayList list = new ArrayList();

        // 1️⃣ Add elements at the end
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding elements: " + list); // [10,20,30]

        // 2️⃣ Add element at specific index
        list.add(1, 15); // Insert 15 at index 1
        System.out.println("After inserting 15 at index 1: " + list); // [10,15,20,30]

        // 3️⃣ Remove element at index
        list.remove(2); // Remove element at index 2 (20)
        System.out.println("After removing element at index 2: " + list); // [10,15,30]

        // 4️⃣ Get element at index
        int val = list.get(1);
        System.out.println("Element at index 1: " + val); // 15

        // 5️⃣ Set element at index
        list.set(2, 50); // Change element at index 2 to 50
        System.out.println("After setting index 2 to 50: " + list); // [10,15,50]

        // 6️⃣ Size of list
        System.out.println("Size of list: " + list.size()); // 3

        // 7️⃣ Clear the list
        list.clear();
        System.out.println("After clearing: " + list); // []
        System.out.println("Size after clearing: " + list.size()); // 0

        // 8️⃣ Adding more elements after clearing
        list.add(100);
        list.add(200);
        System.out.println("After adding new elements: " + list); // [100,200]
    }
}
