import java.util.*;

class DijSPair{
    int dis;
    int node;
    
    public DijSPair(int dis, int node){
        this.dis = dis;
        this.node = node;
    }
}

class dijkstra_using_Set_Solution{
    public int[] dijkstra_using_Set(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int S){
        int[] dist = new int[V];
        
        for(int i=0;i<V;i++) dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;
        
        TreeSet<DijSPair> hs=new TreeSet<>(new Comparator<>(){
            public int compare(DijSPair a,DijSPair b){
                if(a.dis==b.dis) return a.node-b.node;
                return a.dis-b.dis;
            }
        });
        hs.add(new DijSPair(0,S));
        
        while(!hs.isEmpty()){
            
            int dis =  hs.first().dis;
            int node =  hs.first().node;
            hs.remove(hs.first());
            
            for(int i=0;i<adj.get(node).size();i++){
                
                int targetNode = adj.get(node).get(i).get(0);
                int edgeweight = adj.get(node).get(i).get(1);
                
                if(dis + edgeweight < dist[targetNode]){
                    
                    if(dist[targetNode] != Integer.MAX_VALUE)
                        hs.remove(new DijSPair(dist[targetNode], targetNode));
                        
                    dist[targetNode] = dis + edgeweight;
                    hs.add(new DijSPair(dist[targetNode], targetNode));
                }
            }
        }
        return dist;
    }
}

public class Dijkshtras_Algorithm_using_Set {
    public static void main(String[] args){

        ArrayList<ArrayList<ArrayList<Integer>>> adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
        int V = 3;
        int E = 3;
        int S = 2;
        
        dijkstra_using_Set_Solution solution = new dijkstra_using_Set_Solution();
        solution.dijkstra_using_Set(adj, V, S);
    }
    
}
