
class Floyd_warshall_algorithm_solution{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == -1) matrix[i][j] = (int)(1e9);
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j< n; j++){
                   matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(matrix[i][i] < 0) System.out.println("Negetive cycle");
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == 1e9) matrix[i][j] = -1;
            }
        }
        //print
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

public class Floyd_warshall_algorithm {
    public static void main(String[] args){

        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};

        Floyd_warshall_algorithm_solution solution = new Floyd_warshall_algorithm_solution();
        solution.shortest_distance(matrix);
    }
}
