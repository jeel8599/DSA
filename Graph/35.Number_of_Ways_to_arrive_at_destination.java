import java.util.*;

class WPair{
    int first;
    int second;

    public WPair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Number_of_Ways_to_arrive_at_destination_Solution{
    public int countPaths(int n, int[][] roads) {
        
        List<List<WPair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new WPair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new WPair(roads[i][0], roads[i][2]));
        }

        long[] dist = new long[n];
        for(int i=0;i<n;i++) dist[i] = Long.MAX_VALUE;

        long[] ways = new long[n];

        PriorityQueue<WPair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
        pq.add(new WPair(0,0));
        dist[0] = 0;
        ways[0] = 1;
        
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty()){
            long dis = pq.peek().first;
            long node = pq.peek().second;
            pq.poll();

            for(WPair it: adj.get((int)node)){
                long adjNode = it.first;
                long edW = it.second;

                if(dis + edW < dist[(int)adjNode]){
                    dist[(int)adjNode] = dis + edW;
                    ways[(int)adjNode] = ways[(int)node]; 
                    pq.add(new WPair((int)dist[(int)adjNode],(int)adjNode));
                }
                else if(dis + edW == dist[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node])%mod; 
                }
            }
        }

        return (int)ways[n-1]%(mod);
    }
}
public class Number_of_Ways_to_arrive_at_destination {
    public static void main(String[] args){

        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        Number_of_Ways_to_arrive_at_destination_Solution solution = new Number_of_Ways_to_arrive_at_destination_Solution();
        System.out.println(solution.countPaths(n, roads));

    }
}
