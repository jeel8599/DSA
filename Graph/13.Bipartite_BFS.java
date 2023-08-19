import java.util.*;

class Bipartite_BFS_Solution {
    private boolean bfs(int[][] graph, int[] color, int start){
        Queue<Integer> q = new LinkedList<>();
        color[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();

            for(int it: graph[node]){
                if(color[it] == -1){
                    color[it] = 1- color[node];
                    q.add(it);
                }
                else if(color[it] == color[node]) return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for(int i=0;i<n;i++) color[i] = -1;
        
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bfs(graph, color, i) == false) return false;
            }
        }
        return true;
    }
}

public class Bipartite_BFS {
    public static void main(String[] args){
        int[][] graph = {
            {1,2,3},
            {0,2},
            {0,1,3},
            {0,2}
        };

        Bipartite_BFS_Solution solution = new Bipartite_BFS_Solution();
        System.out.println(solution.isBipartiteBFS(graph));
    }
}
