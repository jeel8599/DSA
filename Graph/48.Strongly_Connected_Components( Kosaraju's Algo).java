public class Strongly_Connected_Components {
    
}
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        
        for(int it: adj.get(node)){
            if(vis[it] == false) dfs(it, adj, vis, st);
        }
        
        st.push(node);
    }
    
    public void dfs3(int node, ArrayList<ArrayList<Integer>> adjT, boolean[] vis){
        vis[node] = true;
        
        for(int it: adjT.get(node)){
            if(vis[it] == false) dfs3(it, adjT, vis);
        }
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        int cnt = 0;
        
        for(int i=0;i<V;i++){
            if(vis[i] == false) dfs(i, adj, vis, st);
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        
        for(int i=0;i<V;i++) adjT.add(new ArrayList<>());
        
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        vis = new boolean[V];
        int size = st.size();
        
        for(int i=0;i<size;i++){
            int it = st.pop();
            if(vis[it] == false){
                dfs3(it,adjT,vis);
                cnt++;
            }
            
        }
        return cnt;
    }
}
