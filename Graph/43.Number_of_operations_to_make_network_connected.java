import java.util.*;

class DisjointSet_N{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet_N(int V){
        for(int i=0;i<=V;i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findUPar(int node){
        if(parent.get(node) == node){
            return node;
        }
        else{
            int ulp = findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
    }

    public void UnionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rankU = parent.get(ulp_u);
            parent.set(ulp_u, rankU + 1);
        }
    }

    public void UnionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Number_of_operations_to_make_network_connected_Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet_N ds = new DisjointSet_N(n);
        int cntExtras = 0;
        int components = 0;

        for(int[] it: connections){
            int u = it[0];
            int v = it[1];

            if(ds.findUPar(u) == ds.findUPar(v)) cntExtras++;
            else ds.UnionBySize(u,v);
        }

        for(int i=0;i<n;i++){
            if(i == ds.findUPar(i)) components++;
        }

        int ans = components - 1;
        if(cntExtras >= ans) return ans;
        else return -1;
    }
}

public class Number_of_operations_to_make_network_connected {
    public static void main(String[] args){

        int n = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};

        Number_of_operations_to_make_network_connected_Solution solution = new Number_of_operations_to_make_network_connected_Solution();
        System.out.println(solution.makeConnected(n, connections));

    }
}
