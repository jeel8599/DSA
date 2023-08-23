import java.util.*;

class MMPair{
    int first;
    int second;
    
    public MMPair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Minimum_Multiplications_to_reach_End_Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        int[] dist = new int[100000];

        for(int i=0;i<100000;i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;
        
        Queue<MMPair> q = new LinkedList<>();
        q.add(new MMPair(0,start));
        
        while(!q.isEmpty()){
            int steps = q.peek().first;
            int number = q.peek().second;
            q.poll();
            
            for(int i: arr){
                int num = (i*number) % 100000;
                if(steps+1 < dist[num]){
                    dist[num] = steps + 1;
                    q.add(new MMPair(dist[num],num));
                }
            }
        }
        if(dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}

public class Minimum_Multiplications_to_reach_End {
    public static void main(String[] args){
        int[] arr = {2,5,7};
        int start = 3, end = 30;

        Minimum_Multiplications_to_reach_End_Solution solution = new Minimum_Multiplications_to_reach_End_Solution();
        System.out.println(solution.minimumMultiplications(arr, start, end));
    }
    
}
