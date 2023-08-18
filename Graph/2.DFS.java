//starting node is zero.

import java.util.ArrayList;
import java.util.List;

class GraphDFS{
    public List<Integer> dfsTraversal(List<List<Integer>> adj, int index, List<Integer> res, boolean[] vis){

        res.add(index);

        vis[index] = true;

        List<Integer> ls = adj.get(index);

        for(int i=0;i<ls.size();i++){
            if(vis[ls.get(i)] == false){
                dfsTraversal(adj, ls.get(i),res,vis);
            }
        }
        
        return res;
    }
    public List<Integer> dfs(List<List<Integer>> adj, int n){
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];

        dfsTraversal(adj,0,res,vis);
        return res;
    }
    
}


public class graph_dfs {
    public static void main(String[] args){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<5;i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(0).add(2); adj.get(0).add(4);
        adj.get(1).add(0); adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(3).add(1);adj.get(3).add(4);
        adj.get(4).add(0);adj.get(4).add(3);

        GraphDFS solution = new GraphDFS();
        System.out.println(solution.dfs(adj,5));
    }
}
