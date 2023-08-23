// path from 1 to n

import java.util.*;

class SPPair{
    int wt;
    int node;
    
    public SPPair(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}

class Shortest_Path_in_Weighted_UG_Solution{

    private int[] dijkshtra(int n, List<List<SPPair>> adj){

        PriorityQueue<SPPair> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        int[] dist = new int[n+1];
        int[] pathNode = new int[n+1];
        
        
        for(int i=0;i<=n;i++) dist[i] = Integer.MAX_VALUE;
        
        pq.add(new SPPair(0,1));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            int wt = pq.peek().wt;
            int node = pq.peek().node;
            pq.poll();
            
            for(SPPair it : adj.get(node)){
                int edge_wt = it.wt;
                int adjNode = it.node;
                
                if(wt + edge_wt < dist[adjNode]){
                    dist[adjNode] = wt + edge_wt;
                    pathNode[adjNode] = node;
                    pq.add(new SPPair(dist[adjNode], adjNode));
                }
            }
        }
        return pathNode;
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
                
        List<Integer> result = new ArrayList<>();
        List<List<SPPair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<m;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(start).add(new SPPair(wt,end));
            adj.get(end).add(new SPPair(wt,start));
        }
        
        int[] pathNode = dijkshtra(n, adj);
        
        if(pathNode[n] == 0) result.add(-1);       
        else{
            int i = n;
            result.add(n);
            while(i != 1){
                result.add(pathNode[i]);
                i = pathNode[i];
            }
        }  

        //System.out.println(result);
        Collections.reverse(result);
        return result;
    }
}

public class Shortest_Path_in_Weighted_UG {
    public static void main(String[] args){

        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1}, {4,3,3}, {3,5,1}};
        int n = 5, m = 6;
        
        Shortest_Path_in_Weighted_UG_Solution solution = new Shortest_Path_in_Weighted_UG_Solution();
        System.out.println(solution.shortestPath(n, m, edges));
    }
}
