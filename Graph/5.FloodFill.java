import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class FloodFillSolution{
    public int[][] bfs(int[][] ans, int sr, int sc, int color, int initial, int[] delrow, int[] delcol, boolean[][] vis){
        vis[sr][sc] = true;

        Queue<Pair> q = new LinkedList<>();
        int r = ans.length;
        int c = ans[0].length;

        q.add(new Pair(sr,sc));
        ans[sr][sc] = color;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && ans[nrow][ncol] == initial && vis[nrow][ncol] == false ){
                    vis[nrow][ncol] = true;
                    ans[nrow][ncol] = color;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return ans;
    }


    public void floodFill(int[][] image, int sr, int sc, int color){
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        int r = image.length;
        int c = image[0].length;

        boolean[][] vis = new boolean[r][c];
        int[][] ans = new int[r][c];
        int initial = image[sr][sc];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j] = image[i][j];
            }
        }

        bfs(ans, sr, sc, color, initial, delrow, delcol, vis);

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class FloodFill {
    public static void main(String[] args){
        int[][] image = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};

        int sr = 1, sc = 1, color = 2;

        FloodFillSolution solution = new FloodFillSolution();
        solution.floodFill(image,sr,sc,color);

    }
}
