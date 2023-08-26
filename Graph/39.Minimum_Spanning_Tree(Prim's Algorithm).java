import java.util.*;

class Minimum_Spanning_Tree_Solution{
    public int spanningTree(int V, int E, int edges[][]){
	    List<List<Pair>> adj = new ArrayList<>();
	    
	    for(int i=0;i<V;i++) adj.add(new ArrayList<>());
	    
	    for(int i=0;i<E;i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.first-y.first);
	    boolean[] vis = new boolean[V];
	    int sum  = 0;
	    //wt, node
	    pq.add(new Pair(0,0));
	    
	    while(!pq.isEmpty()){
	        int wt = pq.peek().first;
	        int node = pq.peek().second;
	        pq.poll();
	        
	        if(vis[node] == false){
	            vis[node] = true;
	            sum += wt;
	            
	            for(Pair it: adj.get(node)){
	                int adjNode = it.first;
	                int edW = it.second;
	                
	                if(vis[adjNode] == false){
	                    pq.add(new Pair(edW,adjNode));
	                }
	            }
	        }
	    }
	    return sum;
	}
}

public class Minimum_Spanning_Tree {
    public static void main(String[] args){

        int V = 3, E = 3;
        int[][] edges = {{0,1,5}, {1,2,3},{0,2,1}};

        Minimum_Spanning_Tree_Solution solution = new Minimum_Spanning_Tree_Solution();
        System.out.println(solution.spanningTree(V, E, edges));
    }
}
