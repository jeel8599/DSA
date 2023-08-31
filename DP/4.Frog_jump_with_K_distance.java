import java.util.*;

// Memoization: TC: O(N*K)    SC: O(N) + O(N)
public class Frog_jump_with_K_distance {
    static int f(int[] dp, int n, int[] arr, int K){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];
        int minSteps = Integer.MAX_VALUE;

        for(int j=1;j<=K;j++){
            if((n-j) >= 0){
                int jump = f(dp, n-j, arr, K) + Math.abs(arr[n] - arr[n-j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        return dp[n] = minSteps;
    }
    public static void main(String[] args){
        
        int n = 6, K = 2;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++) dp[i] = -1;
        System.out.println(f(dp, n-1, arr, K));
    }  
}

// Tabulation: TC: O(N*K)    SC: O(N)
public class Frog_jump_with_K_distance {
    public static void main(String[] args){       
        int n = 6, K = 2;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++) dp[i] = -1;
        dp[0] = 0;

        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=K;j++){
                if((i-j) >= 0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        System.out.println(dp[n-1]);
    }  
}

// space optimization is not possible or we can optimized till O(K)
