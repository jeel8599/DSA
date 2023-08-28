// Krushkal's Algo:
// 1. Sort all the edges aacoriding weight
// 2. Define disjoint set for all the vertex.
// 3. Find ultimate parent of all the vertices of edges.

import java.util.*;

class DisjointSet_K{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet_K(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Minimum_Spanning_Tree_KrushkalAlgo_Solution{

    public int spanningTreeKrushkal(int V, int E, int[][] edges){

        int mstWt = 0;
        Arrays.sort(edges,(x,y)->x[2]-y[2]);
        DisjointSet_K ds = new DisjointSet_K(V);

        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }

}

public class Minimum_Spanning_Tree_KrushkalAlgo {
    public static void main(String[] args){

        int V = 3, E = 3;
        int[][] edges = {{0,1,5}, {1,2,3},{0,2,1}};

        Minimum_Spanning_Tree_KrushkalAlgo_Solution solution = new Minimum_Spanning_Tree_KrushkalAlgo_Solution();
        System.out.println(solution.spanningTreeKrushkal(V, E, edges));
    }
}
