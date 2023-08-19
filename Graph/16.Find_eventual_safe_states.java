import java.util.*;

class Find_eventual_safe_states_Solution {
    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathvis, boolean[] check){

        vis[node] = true;
        pathvis[node] = true;
        check[node] = false;

        for(int it : graph[node]){
            if(vis[it] == false){
                if(dfs(it, graph, vis, pathvis, check) == true) return true;
            }
            else if(pathvis[it] == true) return true;
        }

        check[node] = true;
        pathvis[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();

        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n]; 
        boolean[] check = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                dfs(i, graph, vis, pathvis, check);
            }
        }

        for(int i=0;i<n;i++){
            if(check[i] == true) safeNodes.add(i);
        }
        return safeNodes;
    }
}

public class Find_eventual_safe_states {

    public static void main(String[] args){  

        int[][] graph = { {1,2}, {2,3}, {5}, {0}, {5}, {}, {}};

        Find_eventual_safe_states_Solution solution = new Find_eventual_safe_states_Solution();
        System.out.println(solution.eventualSafeNodes(graph));
    }   
}
