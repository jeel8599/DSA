import java.util.*;

class DetectCycleinDGBFS{

    public boolean isCycleBFS(int[][] graph, int V){

        //List<Integer> topo = new ArrayList<>();
        int n =graph.length;
        int[] indegree = new int[n];
        Queue<Integer> q =new LinkedList<>();
        int cnt = 0;

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
            //topo.add(node); 
            cnt++;

            for(int it: graph[node]){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(cnt != V) return true;
        return false;
    }

}


public class Detect_Cycle_in_Directed_Graph_BFS {
    public static void main(String[] args){

        int[][] graph = { {}, {2}, {3}, {4,7}, {5}, {6}, {}, {5}, {9}, {10}, {8}};

        DetectCycleinDGBFS solution = new DetectCycleinDGBFS();
        System.out.println(solution.isCycleBFS(graph,11));
    }
}
