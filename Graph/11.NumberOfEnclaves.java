
class NumberOfEnclaves_Solution{

    private void enclavesDfs(int ro, int co, int[][] grid, boolean[][] vis, int[] delrow, int[] delcol){

        int r = grid.length;
        int c = grid[0].length;
        
        vis[ro][co] = true;

        for(int i=0;i<4;i++){
            int nrow = ro + delrow[i];
            int ncol = co + delcol[i];

            if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                enclavesDfs(nrow, ncol, grid, vis, delrow, delcol);
            }
        }
    }

    public void numEnclaves(int[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[r][c];

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        //mark visited true where from 1 if we can go out

        for(int j=0;j<c;j++){
            //first row
            if(grid[0][j] == 1 && vis[0][j] == false){
                vis[0][j] = true;
                enclavesDfs(0, j, grid, vis, delrow, delcol);
            }

            //last row
            if(grid[r-1][j] == 1 && vis[r-1][j] == false){
                vis[r-1][j] = true;
                enclavesDfs(r-1, j, grid, vis, delrow, delcol);
            }
        }

        for(int i=0;i<r;i++){
            //first col
            if(grid[i][0] == 1 && vis[i][0] == false){
                vis[i][0] = true;
                enclavesDfs(i, 0, grid, vis, delrow, delcol);
            }

            //last col
            if(grid[i][c-1] == 1 && vis[i][c-1] == false){
                vis[i][c-1] = true;
                enclavesDfs(i, c-1, grid, vis, delrow, delcol);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1 && vis[i][j] == false) cnt++;
            }
        }
        System.out.println(cnt);
    }
}

public class NumberOfEnclaves {
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0},
                        {1,0,1,0},
                        {0,1,1,0},
                        {0,0,0,0}};

        NumberOfEnclaves_Solution solution = new NumberOfEnclaves_Solution();
        solution.numEnclaves(grid);

    }
}
