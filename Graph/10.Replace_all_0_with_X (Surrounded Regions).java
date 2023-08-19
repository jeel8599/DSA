
class Replace_all_0_with_X_Solution{

    private void replaceDfs(int ro, int co, char[][] mat, boolean[][] vis, int n, int m, int[] delrow, int[] delcol){

        vis[ro][co] = true;

        for(int i=0;i<4;i++){
            int nrow = ro + delrow[i];
            int ncol = co + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == false && mat[nrow][ncol] == 'O'){
                vis[nrow][ncol] = true;
                replaceDfs(nrow, ncol, mat, vis, n, m, delrow, delcol);
            }
        }
    }

    public void fill(int n,int m, char[][] mat){

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        boolean[][] vis = new boolean[n][m];
        
        //first row
        for(int i=0;i<m;i++){
            if(mat[0][i] == 'O' && vis[0][i] == false){
                replaceDfs(0, i, mat, vis, n, m, delrow, delcol);
            }
        }

        //first col
        for(int i=0;i<n;i++){
            if(mat[i][0] == 'O' && vis[i][0] == false){
                replaceDfs(i,0, mat, vis, n, m, delrow, delcol);
            }
        }

        //last row
        for(int i=0;i<m;i++){
            if(mat[n-1][i] == 'O' && vis[n-1][i] == false){
                replaceDfs(n-1, i, mat, vis, n, m, delrow, delcol);
            }
        }

        //last col
        for(int i=0;i<n;i++){
            if(mat[i][m-1] == 'O' && vis[i][m-1] == false){
                replaceDfs(i, m-1, mat, vis, n, m, delrow, delcol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 'O' && vis[i][j] == false) mat[i][j] = 'X';
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

public class Replace_all_0_with_X {
    public static void main(String[] args){
        char[][] mat = {{'X','X','X','X','X'},
                        {'X','O','O','X','O'},
                        {'X','X','O','X','O'},
                        {'X','O','X','O','X'},
                        {'O','O','X','X','X'}};

        int n = mat.length;
        int m = mat[0].length;

        Replace_all_0_with_X_Solution solution = new Replace_all_0_with_X_Solution();
        solution.fill(n,m,mat);

    }
}
