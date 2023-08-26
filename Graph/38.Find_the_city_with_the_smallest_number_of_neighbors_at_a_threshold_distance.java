
class Find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance_solution{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adj = new int[n][n];
        int min = Integer.MAX_VALUE, min_index = 0, cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j) adj[i][j] = (int)(1e9);
                else adj[i][j] = 0;
            }
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj[u][v] = wt;
            adj[v][u] = wt;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            cnt = 0;
            for(int j=0;j<n;j++){
                if(i != j && adj[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= min){
                min = cnt;
                min_index = i;
            }
        }
        return min_index;
    }
}

public class Find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance{
    public static void main(String[] args){

        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};

        Find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance_solution solution = new Find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance_solution();
        System.out.println(solution.findTheCity(n,edges,distanceThreshold));
    }
}