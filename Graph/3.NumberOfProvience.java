import java.util.ArrayList;
import java.util.List;

class NumOfProvience{

    public void dfs(int index, List<List<Integer>> adj,boolean[] vis){
        
        if(vis[index] == true) return;
        
        vis[index] = true;

        List<Integer> ls = adj.get(index); 
        for(int i=0;i<ls.size();i++){
            dfs(ls.get(i), adj,vis);
        }
    }
    
    public int findNumberOfProvience(int[][] isConnected){
        int n = isConnected.length;
        boolean[] vis = new boolean[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        int cnt = 0;
        
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        System.out.println(adj);

        for(int i=1;i<=n;i++){
            if(vis[i] != true){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
}
public class NumberOfProvience {

    public static void main(String[] args){
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        NumOfProvience solution = new NumOfProvience();
        System.out.println(solution.findNumberOfProvience(isConnected));
    }
    
}
