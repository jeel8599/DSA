import java.util.*;

class Number_of_Distinct_Islands_Solution{

    private ArrayList<String> distincIslandsDFS(int ro, int co, int[][] grid, boolean[][] vis, ArrayList<String> ls, int base_row, int base_col){

        vis[ro][co] = true;
        ls.add(toString(ro-base_row, co - base_col));

        int r = grid.length;
        int c = grid[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = ro + delrow[i];
            int ncol = co + delcol[i];

            if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                vis[nrow][ncol] = true;
                distincIslandsDFS(nrow, ncol, grid, vis, ls, ro, co);
            }
        }
        return ls;
    }

    private String toString(int r, int c){
        return Integer.toString(r) + "  " + Integer.toString(c);
    }

    public int findNumberOfDistinctIslands(int[][] grid){

        int r = grid.length;
        int c = grid[0].length;

        HashSet<ArrayList<String>> hs = new HashSet<>();
        boolean[][] vis = new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                
                if(vis[i][j] == false && grid[i][j] == 1){
                    ArrayList<String> ls = new ArrayList<>();
                    ls = distincIslandsDFS(i, j, grid, vis, ls, i, j);
                    hs.add(ls);
                }
            }
        }


        return hs.size();
    }
}

public class Number_of_Distinct_Islands{

    public static void main(String[] args){
    
        int[][] grid = {
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,1},
            {1,1,0,1,1}
        };

        Number_of_Distinct_Islands_Solution solution = new Number_of_Distinct_Islands_Solution();
        System.out.println(solution.findNumberOfDistinctIslands(grid));
    }
    
}
