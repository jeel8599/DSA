class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int V){
        for(int i=0;i<=V;i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findUPar(int node){
        if(parent.get(node) == node){
            return node;
        }
        else{
            int ulp = findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
    }

    public void UnionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rankU = parent.get(ulp_u);
            parent.set(ulp_u, rankU + 1);
        }
    }

    public void UnionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }


}
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int cnt = 0;

        DisjointSet ds = new DisjointSet(isConnected.length);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1) ds.UnionBySize(i,j);
            }
        }

        for(int i=0;i<n;i++){
            if(i == ds.parent.get(i)) cnt++;
        }
        return cnt;
    }
}