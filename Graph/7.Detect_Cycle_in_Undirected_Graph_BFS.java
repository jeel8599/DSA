import java.util.*;

class CPair{
    int node;
    int parent;
    public CPair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

class DetectCycleinUGBFS{
    private boolean checkForCycleinUGBFS(int start, List<List<Integer>> adj, boolean[] vis){

        Queue<CPair> q = new LinkedList<>();
        q.add(new CPair(start, -1));
        vis[start] = true;

        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();

            List<Integer> ls = adj.get(node);

            for(int i=0;i<ls.size();i++){
                if(vis[ls.get(i)] == false){
                    q.add(new CPair(ls.get(i), node));
                    vis[ls.get(i)] = true;
                }
                else if(ls.get(i) != parent) return true;
            }
        }
        return false;

    }
    public boolean isCycle(List<List<Integer>> adj, int n){

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                if(checkForCycleinUGBFS(i, adj, vis) == true) return true;
            }
        }
        return false;
    }
}


public class Detect_Cycle_in_Undirected_Graph_BFS {
    public static void main(String[] args){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<8;i++) adj.add(new ArrayList<>());

        adj.get(1).add(2); adj.get(1).add(3);
        adj.get(2).add(1); adj.get(2).add(5);
        adj.get(3).add(1); adj.get(3).add(4); adj.get(3).add(6);
        adj.get(4).add(3);
        adj.get(5).add(2);adj.get(5).add(7);
        adj.get(6).add(3);adj.get(6).add(7);
        adj.get(7).add(5);adj.get(7).add(6);

        DetectCycleinUGBFS solution = new DetectCycleinUGBFS();
        System.out.println(solution.isCycle(adj,8));
    }
}
