import java.util.*;

class PathPair{
    int node;
    int wt;

    public PathPair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
class shortest_path_in_directed_acyclic_graph_solution{

    public void ShortestPathInDAG(int[][] edges, int n, int m){

        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = Integer.MAX_VALUE;

        List<List<PathPair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int st = edges[i][0];
            int end = edges[i][1];
            int wt = edges[i][2];

            adj.get(st).add(new PathPair(end, wt));
        }
        int src = 0;
        dist[src] = 0;

        Queue<PathPair> q = new LinkedList<>();
        q.add(new PathPair(0, 0));

        System.out.println(q);

        while(!q.isEmpty()){
            int node = q.peek().node;
            int wt = q.peek().wt;
            q.poll();

            for(PathPair it: adj.get(node)){
                int it_node = it.node;
                int it_wt = it.wt;

                if(dist[it_node] > wt + it_wt){
                    dist[it_node] = wt + it_wt;
                    q.add(new PathPair(it_node, wt + it_wt));
                }
            }
            System.out.println(q);
        }

        for(int i=0;i<n;i++) System.out.print(dist[i] + " ");

    }
}

public class shortest_path_in_directed_acyclic_graph {
    public static void main(String[] args){

        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int n = 6, m = 7;
        
        shortest_path_in_directed_acyclic_graph_solution solution = new shortest_path_in_directed_acyclic_graph_solution();
        solution.ShortestPathInDAG(edges, n, m);
    }
}
