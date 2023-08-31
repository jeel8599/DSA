import java.util.Scanner;

// Ways to solve DP:
// 1. Tabulation  --> Bottom Up (Basecase to required ans)
// 2. Memoization  --> Top Down (Required ans to base case)

// Memoization --> Tabulation --> Optimized space


// Memoization:  TC: O(N)   SC:O(N)+O(N)
public class Fibonacci_DP{

    static int f(int[] dp, int n){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];
        return dp[n] = f(dp, n-1) + f(dp, n-2);
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++) dp[i] = -1;
        f(dp,n);
        System.out.println(dp[n]);
    }
}

// Tabulation: TC: O(N)     SC:O(N)
public class Fibonacci_DP{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1]; 

        dp[0] = 0; dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]); 
    }
}

// Space optimization: TC: O(N)     SC:O(1)
public class Fibonacci_DP{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int prev2 = 0; prev = 1;

        for(int i=2;i<=n;i++){
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }

        System.out.println(prev);
    }
}