import java.util.*;

class Find_eventual_safe_states_BFS_Solution {

    public List<Integer> eventualSafeNodesBFS(int[][] graph) {

        List<List<Integer>> adjRev = new ArrayList<>();
        int[] indegree = new int[graph.length];
        List<Integer> topo = new ArrayList<>();

        for(int i=0;i<graph.length;i++) adjRev.add(new ArrayList<>());

        for(int i=0;i<graph.length;i++){
            for(int it: graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add(node);

            for(int it: adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(topo);

        return topo;
    }
}

public class Find_eventual_safe_states_BFS {

    public static void main(String[] args){  

        int[][] graph = { {1,2}, {2,3}, {5}, {0}, {5}, {}, {}};

        Find_eventual_safe_states_BFS_Solution solution = new Find_eventual_safe_states_BFS_Solution();
        System.out.println(solution.eventualSafeNodesBFS(graph));
    }   
}
