import java.util.*;

class Shortest_path_in_directed_UG_solution{

    public void ShortestPathInUG(int[][] edges, int n, int m, int src){

        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = Integer.MAX_VALUE;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int st = edges[i][0];
            int end = edges[i][1];

            adj.get(st).add(end);
        }

        dist[src] = 0;

        Queue<PathPair> q = new LinkedList<>();
        q.add(new PathPair(0, 0));

        System.out.println(q);

        while(!q.isEmpty()){
            int node = q.peek().node;
            int wt = q.peek().wt;
            q.poll();

            for(int it: adj.get(node)){
                if(dist[it] > wt + 1){
                    dist[it] = wt + 1;
                    q.add(new PathPair(it, wt + 1));
                }
            }
            System.out.println(q);
        }

        for(int i=0;i<n;i++) System.out.print(dist[i] + " ");

    }
}

public class Shortest_path_in_UG {
    public static void main(String[] args){

        int[][] edges = {{0,1}, {0,3}, {3,4}, {4,5}, {5,6}, {1,2}, {2,6}, {6,7}, {6,8}, {7,8}};
        int n = 9, m = 10, src =0;
        
        Shortest_path_in_directed_UG_solution solution = new Shortest_path_in_directed_UG_solution();
        solution.ShortestPathInUG(edges, n, m, src);
    }
}
