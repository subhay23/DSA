import java.util.ArrayList;

public class Dsu {

    ArrayList<Integer> parent;
    public Dsu(int n){
        parent = new ArrayList<>();
        for(int i=0 ;i<n ;i++){
            parent.add(i);
        }
    }

    public int find(int node){
        if(node==parent.get(node)){
            return node;
        }
        return find(parent.get(node));
    }
    public void union(int node1, int node2){

        int node1_parent = find(node1);
        int node2_parent = find(node2);

        if(node1_parent != node2_parent){
            parent.set(node2_parent,node1_parent); 
        }
    }
}
