
import java.util.*;

class MatPair{
    int first;
    int second;
    int dist;

    public MatPair(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}
class DistanceOfCell1Solution{
    public void updatedMatrix(int[][] mat){

        int r = mat.length;
        int c = mat[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        boolean[][] vis = new boolean[r][c];
        int[][] res = new int[r][c];

        Queue<MatPair> q = new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new MatPair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int d = q.peek().dist;
            res[row][col] = d;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >=0 && nrow <r && ncol >= 0 && ncol < c && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    q.add(new MatPair(nrow, ncol, d+1));
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

public class distance_of_nearest_cell_having_1 {
    public static void main(String[] args){
        int[][] mat = {{0,0,0},
                       {0,1,0},
                       {1,0,1}};

        DistanceOfCell1Solution solution = new DistanceOfCell1Solution();
        solution.updatedMatrix(mat);

    }
}
