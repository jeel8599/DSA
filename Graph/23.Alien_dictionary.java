import java.util.*;

class alien_dictionary_solution{
    public int findOrder(String[] dict, int N, int K){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<K;i++) adj.add(new ArrayList<>());

        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(),s2.length());

            for(int j=0;j<len;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        int[] indegree = new int[K];

        for(int i=0;i<K;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Character> topo = new ArrayList<>();

        for(int i=0;i<K;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add((char)(node + 'a'));

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(topo.size() == K) return 1;
        return 0;
    }
}   

public class alien_dictionary {
    public static void main(String[] args){

        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = 5, K = 4;
        
        alien_dictionary_solution solution = new alien_dictionary_solution();
        System.out.println(solution.findOrder(dict, N, K));
    }
}
