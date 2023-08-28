class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {

        int n = 0;
        int m = 0;

        for(int[] it: stones){
            n = Math.max(n,it[0]);
            m = Math.max(m,it[1]);
        }
        //System.out.println(n + " " + m);

        DisjointSet ds = new DisjointSet(n+m+1);
        HashSet<Integer> hs = new HashSet<>();
        for(int[] it: stones){
            int row = it[0];
            int col = it[1] + n + 1;
            ds.unionBySize(row,col);
            hs.add(row);
            hs.add(col);

        }
        // System.out.println(ds.size);
        // System.out.println(ds.parent);
        int components = 0;

        for(int it: hs){
            if(ds.parent.get(it) == it) components++;
        }
        //System.out.println(components);
        return ((stones.length)-components);
    }
}