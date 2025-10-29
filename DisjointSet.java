public class DisjointSet {
    
    int[] parent;
    int[] rank;
    int[] size;
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0; i<n ;i++){
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }

    }
    public int find(int i){
        if(i==parent[i])return i;

        return parent[i] = find(parent[i]);
    }

    public void unionByRank(int node1, int node2){
        
        int node1_parent = find(node1);
        int node2_parent = find(node2);
        
        if(node1_parent == node2_parent) return;

        if(rank[node1_parent] > rank[node2_parent]){
            parent[node2_parent] = node1_parent;
        }
        else if(rank[node2_parent] > rank[node1_parent]){
            parent[node1_parent] = node2_parent;
        }
        else{
            parent[node1_parent] = node2_parent;
            rank[node2_parent]++;
        }

    }
    public void unionBySize(int node1, int node2){

        int node1_parent = find(node1);
        int node2_parent = find(node2);
        
        if(node1_parent == node2_parent) return;

        if(size[node1_parent] > size[node2_parent]){
            parent[node2_parent] = node1_parent;
            size[node1_parent] += size[node2_parent];
        }
        else if(size[node2_parent] > size[node1_parent]){
            parent[node1_parent] = node2_parent;
            size[node2_parent] += size[node1_parent];
        }
        else{
            parent[node1_parent] = node2_parent;
            size[node2_parent] += size[node1_parent];
        }
    }
}
