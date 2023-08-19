import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Topological_sorting_solution{
    public void dfs(int node, boolean[] vis, int[][] graph, Stack<Integer> st){
        vis[node] = true;
        for(int it: graph[node]){
            if(vis[it] == false){
                dfs(it, vis, graph, st);
            }
        }
        st.push(node);
    }

    public List<Integer> topoSort(int[][] graph){

        int n = graph.length;
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                dfs(i, vis, graph, st);
            }
        }
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}

public class Topological_sorting {
    public static void main(String[] args){  
        int[][] graph = { {}, {}, {3}, {1}, {0,1}, {0,2}};
        Topological_sorting_solution solution = new Topological_sorting_solution();
        System.out.println(solution.topoSort(graph));
    }
}
