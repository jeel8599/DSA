class Solution {
    private int timer = 1;
    private List<List<Integer>> dfs(int node, List<List<Integer>> adj, boolean[] vis, int[] time, int[] low, List<List<Integer>> ans, int parent){
        vis[node] = true;
        time[node] = timer;
        low[node] = timer;
        timer++;
        for(int it: adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == false){
                dfs(it,adj,vis,time,low,ans,node);
                low[node] = Math.min(low[node],low[it]);
                if(time[node] < low[it]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(it);
                    ans.add(temp);
                }
            }
            else low[node] = Math.min(low[node],low[it]);
        }
        return ans;
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(List<Integer> it : connections){
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }

        int[] time = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i] == false){
                dfs(i,adj,vis,time,low,ans,-1);
            }
        }
        return ans;
    }
}