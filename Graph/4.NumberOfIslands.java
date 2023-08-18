import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class NumOfIslands{

    public void bfs(int ro,int co, char[][] grid,int[][] vis, int[] delrow, int[] delcol){
        vis[ro][co] = 1;

        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >=0 && nrow < r && ncol >=0 && ncol < c && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }    
            }
        }
    }

    public int findNumberOfIslands(char[][] grid){

        int r = grid.length;
        int c = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[r][c];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,grid,vis,delrow,delcol);       
                }
            }
        }
        
        return cnt;
    }

}
public class NumberOfIslands {
    public static void main(String[] args){
    
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        NumOfIslands solution = new NumOfIslands();
        System.out.println(solution.findNumberOfIslands(grid));
    }
}
