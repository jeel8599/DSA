import java.util.*;

class CourseScheduleI_Solution{

    public boolean isPossible(int[][] graph, int V){

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

        if(cnt == V) return true;
        return false;
    }

}

public class course_schdule_I {
    public static void main(String[] args){

        int[][] prerequisites = {{1},{0}};
        int V = 2;

        CourseScheduleI_Solution solution = new CourseScheduleI_Solution();
        System.out.println(solution.isPossible(prerequisites,V));
    }
}
