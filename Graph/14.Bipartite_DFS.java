
class Bipartite_DFS_Solution {

    private boolean dfs(int[][] graph, int[] color, int node){

        for(int it: graph[node]){
            if(color[it] == -1){
                color[it] = 1 - color[node];
                if(dfs(graph, color, it) == false) return false;
            }
            else if(color[it] == color[node]) return false;
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for(int i=0;i<n;i++) color[i] = -1;
        
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                color[i] = 0;
                if(dfs(graph, color, i) == false) return false;
            }
        }
        return true;
    }
}

public class Bipartite_DFS {
    public static void main(String[] args){
        int[][] graph = {
            {1,2,3},
            {0,2},
            {0,1,3},
            {0,2}
        };

        Bipartite_DFS_Solution solution = new Bipartite_DFS_Solution();
        System.out.println(solution.isBipartiteDFS(graph));
    }
}   
