import java.util.Scanner;

// Memoization: TC: O(N) SC: O(N) + O(N)
public class Frog_Jump {
    static int f(int[] dp, int n, int[] arr){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];
        int left = f(dp, n-1, arr) + Math.abs(arr[n] - arr[n-1]);

        int right  = Integer.MAX_VALUE;
        if(n > 1) right = f(dp, n-2, arr) + Math.abs(arr[n] - arr[n-2]);

        return dp[n] = Math.min(left,right);
    }
    public static void main(String[] args){
        
        int n = 6;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++) dp[i] = -1;
        System.out.println(f(dp,n-1,arr));
    }
}

//Tabulation: TC: O(N)   SC:O(N)
public class Frog_Jump {
    public static void main(String[] args){
        
        int n = 6;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++) dp[i] = -1;
        dp[0] = 0;

        for(int i=1;i<n;i++){
            int left = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);

            dp[i] = Math.min(left,right);
        }
        System.out.println(dp[n-1]);
    }
}

// space optimization: TC: O(N)   SC:O(1)
public class Frog_Jump {
    public static void main(String[] args){
        
        int n = 6;
        int[] arr = {30, 10, 60, 10, 60, 50};
        int prev = 0, prev2 = 0;

        for(int i=1;i<n;i++){
            int left = prev + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2 + Math.abs(arr[i] - arr[i-2]);

            int curi = Math.min(left,right);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
