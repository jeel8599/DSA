import java.util.*;

class CourseScheduleII_Solution{

    public List<Integer> isPossibleII(int[][] graph, int V){

        List<Integer> topo = new ArrayList<>();
        int n = graph.length;
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

        if(topo.size()== V) return topo;
        else return new ArrayList<>();

    }

}

public class course_schdule_II {
    public static void main(String[] args){

        int[][] prerequisites = {{1},{}};
        int V = 2;

        CourseScheduleII_Solution solution = new CourseScheduleII_Solution();
        System.out.println(solution.isPossibleII(prerequisites,V));
    }
}
