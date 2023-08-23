import java.util.*;

class FPair{
    int dest;
    int price;

    public FPair(int dest, int price){
        this.dest = dest;
        this.price = price;
    }
}

class Tuple{
    int stops;
    int node;
    int price;

    public Tuple(int stops, int node, int price){
        this.stops = stops;
        this.node = node;
        this.price = price;
    }
}

class Cheapest_Flights_Within_K_Stops_Solution{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<FPair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] it: flights){
            adj.get(it[0]).add(new FPair(it[1],it[2]));
        }

        int[] dist = new int[n];

        for(int i=0;i<n;i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Tuple> q = new PriorityQueue<>((x,y) -> x.stops - y.stops);
        q.add(new Tuple(0,src,0));
        dist[src] = 0;

        while(!q.isEmpty()){
            int stp = q.peek().stops;
            int node = q.peek().node;
            int price = q.peek().price;
            q.poll();

            for(FPair it: adj.get(node)){
                int adjNode = it.dest;
                int edW = it.price;

                if(price + edW < dist[adjNode]){
                    if(adjNode == dst && stp <=k){
                        dist[adjNode] = price+ edW;
                    }
                    else if(stp + 1 <= k){
                        dist[adjNode] = price + edW;
                        q.add(new Tuple(stp+1,adjNode,dist[adjNode]));
                    }
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];        
    }
}


public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args){

        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4, src = 0, dst = 3, k = 1;
    
        Cheapest_Flights_Within_K_Stops_Solution solution = new Cheapest_Flights_Within_K_Stops_Solution();
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));    
    }
}
