import java.util.Scanner;

// Count the total no of ways
// Min or Max output
// Count distinct ways
// try all possible ways comes in (count or find best ways)
// in all such case will apply recursion

// Try to represent problem in terms of index
// Do all possible stuffs on that index according to the problem statement
// Sum of all stuffs if we have to count all ways
// Min (of all stuffs) --> find Min same for max

// Memoization: TC: O(N) SC: O(N) + O(N)
public class Climbing_Stairs {

    static int f(int[] dp, int n){
        if(n <= 1) return 1;

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

// Tabulation: TC: O(N) SC: O(N)
public class Climbing_Stairs {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        
        dp[0] = 1; dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);   
    }
}

// Space optimization: TC: O(N)     SC:O(1)
public class Climbing_Stairs{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int prev2 = 1; prev = 1;

        for(int i=2;i<=n;i++){
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }

        System.out.println(prev);
    }
}
