//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    
    private boolean isValid(int nrow, int ncol, int rows, int cols){
        return nrow >=0 && nrow < rows && ncol >=0 && ncol < cols;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
        DisjointSet ds = new DisjointSet(rows*cols);
        
        int[][] vis = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        for(int[] it: operators){
            int row = it[0];
            int col = it[1];
            int nodeNo = row * cols + col;
            
            if(vis[row][col] == 1){ 
                ans.add(cnt);
                continue;
            }
            
            vis[row][col] = 1;
            cnt++;
            
            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                int adjNodeNo = nrow * cols + ncol;
                
                if(isValid(nrow, ncol, rows, cols) == true && vis[nrow][ncol] == 1){
                    if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends