import java.util.*;

class Pair{
    int first;
    int second;
    int tm;
    public Pair(int first, int second,int tm){
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}

class RottenOrangeSolution{

    public int bfs(int[][] grid, int[] delrow, int[] delcol, int[][] vis){

        Queue<Pair> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int time = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            time = q.peek().tm;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 1 ){
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow,ncol,time+1));
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(vis[i][j] == 1) return -1;
            }
        }

        return time;
    }


    public int rottenOrange(int[][] grid){
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        int r = grid.length;
        int c = grid[0].length;

        int[][] vis = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                vis[i][j] = grid[i][j];
            }
        }

        return (bfs(grid,delrow,delcol,vis));
    }
}

public class RottenOranges {
    public static void main(String[] args){
        // int[][] grid = {{2,1,1},
        //                 {1,1,0},
        //                 {0,1,1}};

        int[][] grid = {{1}};

        RottenOrangeSolution solution = new RottenOrangeSolution();
        System.out.println(solution.rottenOrange(grid));

    }
}
