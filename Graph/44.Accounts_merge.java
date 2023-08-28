import java.util.*;

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

class Accounts_merge_Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(hm.containsKey(mail) == true){          
                    ds.unionBySize(i,hm.get(mail));
                }
                else{
                    hm.put(mail,i);
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[n];

        for(int i=0;i<n;i++) mergedMail[i] = new ArrayList<String>();

        for(Map.Entry<String,Integer> it: hm.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String s: mergedMail[i]){
                temp.add(s);
            }
            ans.add(temp);
        }
        return ans;
    }
}


public class Accounts_merge {
    
}
