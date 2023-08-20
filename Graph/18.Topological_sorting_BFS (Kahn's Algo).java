import java.util.*;

class Topological_sorting_BFS_solution{

    public List<Integer> topoSortBFS(int[][] graph){

        List<Integer> topo = new ArrayList<>();
        int n =graph.length;
        int[] indegree = new int[n];
        Queue<Integer> q =new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int it: graph[i]){
                indegree[it]++;
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add(node);

            for(int it: graph[node]){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }

}

public class Topological_sorting_BFS {

    public static void main(String[] args){  
        int[][] graph = { {}, {}, {3}, {1}, {0,1}, {0,2}};
        Topological_sorting_BFS_solution solution = new Topological_sorting_BFS_solution();
        System.out.println(solution.topoSortBFS(graph));
    }
    
}
