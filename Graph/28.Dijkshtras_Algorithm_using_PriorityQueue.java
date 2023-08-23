import java.util.*;

class DijPair{
    int dis;
    int node;
    
    public DijPair(int dis, int node){
        this.dis = dis;
        this.node = node;
    }
}

class dijkstra_using_PQ_Solution{
    public int[] dijkstra_using_PQ(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int S){
        int[] dist = new int[V];
        
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;
        
        PriorityQueue<DijPair> pq = new PriorityQueue<>((x,y) -> x.dis - y.dis);
        pq.add(new DijPair(0,S));
        
        while(!pq.isEmpty()){
            int dis = pq.peek().dis;
            int node = pq.peek().node;
            pq.poll();
            
            for(int i=0;i<adj.get(node).size();i++){
                
                int targetNode = adj.get(node).get(i).get(0);
                int edgeweight = adj.get(node).get(i).get(1);
                
                if(dis + edgeweight < dist[targetNode]){
                    dist[targetNode] = dis + edgeweight;
                    pq.add(new DijPair(dist[targetNode], targetNode));
                }
                
            }
        }
        
        return dist;
    }
}

public class Dijkshtras_Algorithm_using_PriorityQueue {
    public static void main(String[] args){

        ArrayList<ArrayList<ArrayList<Integer>>> adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
        int V = 3;
        int E = 3;
        int S = 2;
        
        dijkstra_using_PQ_Solution solution = new dijkstra_using_PQ_Solution();
        solution.dijkstra_using_PQ(adj, V, S);
    }
    
}
