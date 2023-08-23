import java.util.*;

class MPair{
    int distance;
    int first;
    int second;

    public MPair(int distance, int first, int second){
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}

class Shortest_path_in_Binary_Maze_Solution{

    private boolean isValid(int nrow, int ncol,int n, int m){
        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
            return true;
        }
        return false;
    }

    private int maze_dijkshtra(int[][] mat, int[][] dist, int[] src, int[] dest){

        int n = mat.length;
        int m = mat[0].length;

        Queue<MPair> q = new LinkedList<>();
        q.add(new MPair(0,src[0],src[1]));

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int steps = q.peek().distance;
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(isValid(nrow, ncol, n, m) == true && mat[nrow][ncol] == 1 && steps + 1 < dist[nrow][ncol]){
                    dist[nrow][ncol] = steps + 1;
                    if(nrow == dest[0] && ncol == dest[1]) return steps+1;
                    q.add(new MPair(dist[nrow][ncol], nrow, ncol));
                }
            }
        }
        return -1;
    }

    public int BinaryMazePath(int[][] mat, int[] src, int[] dest){

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[src[0]][src[1]] = 0;
        return maze_dijkshtra(mat, dist, src, dest);
    }
}

public class Shortest_path_in_Binary_Maze {
    public static void main(String[] args){

        int[][] mat = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        int[] src = {0,0};
        int[] dest = {3,4};

        Shortest_path_in_Binary_Maze_Solution solution = new Shortest_path_in_Binary_Maze_Solution();
        System.out.println(solution.BinaryMazePath(mat,src,dest));
    }
}
