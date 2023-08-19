import java.util.*;

class DetectCycleinUGDFS{

    private boolean checkForCycleinUGDFS(int node, List<List<Integer>> adj, boolean[] vis,int parent){

        vis[node] = true;

        for(int adjNode: adj.get(node)){
            if(vis[adjNode] == false){
                if(checkForCycleinUGDFS(adjNode,adj,vis,node) == true) return true;
            }
            else if(adjNode != parent) return true;
        }
        return false;

    }
    public boolean isCycle(List<List<Integer>> adj, int n){

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                if(checkForCycleinUGDFS(i, adj, vis,-1) == true) return true;
            }
        }
        return false;
    }
}


public class Detect_Cycle_in_Undirected_Graph_DFS {
    public static void main(String[] args){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<8;i++) adj.add(new ArrayList<>());

        adj.get(1).add(2); adj.get(1).add(3);   // has cycle
        adj.get(2).add(1); adj.get(2).add(5);
        adj.get(3).add(1); adj.get(3).add(4); adj.get(3).add(6);
        adj.get(4).add(3);
        adj.get(5).add(2);adj.get(5).add(7);
        adj.get(6).add(3);adj.get(6).add(7);
        adj.get(7).add(5);adj.get(7).add(6);

        // adj.get(1).add(2); adj.get(1).add(3);  // no cycle
        // adj.get(2).add(1); adj.get(2).add(5);
        // adj.get(3).add(1); adj.get(3).add(4); adj.get(3).add(6);
        // adj.get(4).add(3);
        // adj.get(5).add(2);adj.get(5).add(7);
        // adj.get(6).add(3);
        // adj.get(7).add(5);

        DetectCycleinUGDFS solution = new DetectCycleinUGDFS();
        System.out.println(solution.isCycle(adj,8));
    }
}
