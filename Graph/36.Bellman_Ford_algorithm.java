import java.util.*;

class Bellman_Ford_algorithm_Solution{
    public void bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        
        for(int i=0;i<V;i++) dist[i] = (int)(1e8);
        dist[S] = 0;
        
        for(int j=0;j<V-1;j++){
            for(ArrayList<Integer> it: edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                System.out.println(temp[0]);
            }
        }
        for(int i=0;i<V;i++) System.out.print(dist[i] + "  ");
    }
}

public class Bellman_Ford_algorithm {
    public static void main(String[] args) {

        int V = 3, S = 2;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges = {{0,1,5},{1,0,3},{1,2,-1},{2,0,1}};
        
        Bellman_Ford_algorithm_Solution solution = new Bellman_Ford_algorithm_Solution();
        solution.bellman_ford(V, edges, S);
    }
}
