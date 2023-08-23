import java.util.*;

class EPair{
    int effort;
    int first;
    int second;

    public EPair(int effort, int first, int second){
        this.effort = effort;
        this.first = first;
        this.second = second;
    }
}
class Path_With_Minimum_Effort_Solution{

    private boolean isValid(int nrow, int ncol,int n, int m){
        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
            return true;
        }
        return false;
    }

    public int minimumEffort(int[][] heights){

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<EPair> q = new PriorityQueue<>((x,y) -> x.effort - y.effort);
        q.add(new EPair(0,0,0));

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int takenEffort = q.peek().effort;
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            if(row == n-1 && col == m-1) return takenEffort;

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(isValid(nrow, ncol, n, m) == true){
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col]), takenEffort);

                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        q.add(new EPair(dist[nrow][ncol], nrow, ncol));
                    }
                }
            }

        }
        return -1;
    }

}

public class Path_With_Minimum_Effort {
    public static void main(String[] args){

        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
    
        Path_With_Minimum_Effort_Solution solution = new Path_With_Minimum_Effort_Solution();
        System.out.println(solution.minimumEffort(heights));    
    }
}
