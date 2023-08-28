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
    private boolean isValid(int nrow, int ncol, int n){
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < n;
    }

    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int ans = 0;
        DisjointSet ds = new DisjointSet(n*n);

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        //int[][] vis = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int node = i * n + j;
                if(grid[i][j] == 1){
                    for(int k=0;k<4;k++){
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        int adjNode = nrow * n + ncol;
                        if(isValid(nrow,ncol,n) == true && grid[nrow][ncol] == 1){
                            if(ds.findUPar(node) != ds.findUPar(adjNode))
                                ds.unionBySize(node,adjNode);
                        }           
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                HashSet<Integer> hs = new HashSet<>();
                //int node = i * n + j;
                if(grid[i][j] == 0){
                    for(int k=0;k<4;k++){
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        int adjNode = nrow * n + ncol;

                        if(isValid(nrow,ncol,n) == true && grid[nrow][ncol] == 1){
                            hs.add(ds.findUPar(adjNode));
                        }         
                    }
                }
                int Totalsize = 0;
                for(int it: hs){
                    Totalsize += ds.size.get(it);
                }
                ans = Math.max(ans, Totalsize+1);
            }
        }

        for(int i=0;i<n*n;i++) ans = Math.max(ans, ds.size.get(i));

        return ans;
    }
}