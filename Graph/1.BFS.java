//starting node is zero.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphBFS{
    public List<Integer> bfs(List<List<Integer>> adj, int n){

        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            ls = adj.get(q.peek());          
            res.add(q.poll());

            for(int i=0;i<ls.size();i++){
                if(vis[ls.get(i)] == false){
                    q.add(ls.get(i));
                    vis[ls.get(i)] = true;
                }
            }
        }
        return res;
    }
    
}

public class graph_bfs {
    public static void main(String[] args){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<5;i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(0).add(2); adj.get(0).add(4);
        adj.get(1).add(0); adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(3).add(1);adj.get(3).add(4);
        adj.get(4).add(0);adj.get(4).add(3);

        GraphBFS solution = new GraphBFS();
        System.out.println(solution.bfs(adj,5));
    }
}
