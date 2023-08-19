class DetectCycleinDGDFS{

    private boolean checkForCycleinDGDFS(int node, int[][] graph, boolean[] vis, boolean[] pathvis){
        vis[node] = true;
        pathvis[node] = true;

        for(int adjNode: graph[node]){
            if(vis[adjNode] == false){
                if(checkForCycleinDGDFS(adjNode, graph, vis, pathvis) == true) return true;
            }
            else if(pathvis[adjNode] == true) return true;
        }
        pathvis[node] = false;
        return false;

    }
    public boolean isCycle(int[][] graph, int n){

        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                if(checkForCycleinDGDFS(i, graph, vis, pathvis) == true) return true;
            }
        }
        return false;
    }
}


public class Detect_Cycle_in_Directed_Graph_DFS {
    public static void main(String[] args){

        int[][] graph = { {}, {2}, {3}, {4,7}, {5}, {6}, {}, {5}, {9}, {10}, {8}};

        DetectCycleinDGDFS solution = new DetectCycleinDGDFS();
        System.out.println(solution.isCycle(graph,11));
    }
}
