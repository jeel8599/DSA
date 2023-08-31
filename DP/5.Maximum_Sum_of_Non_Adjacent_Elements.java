import java.util.* ;
import java.io.*; 
import java.util.*;

// kind of house robber 1 problem

//Memoization: TC:O(N)  SC: O(N) + O(N)
public class Maximum_Sum_of_Non_Adjacent_Elements {
    static int f(ArrayList<Integer> nums, int index, int[] dp){
		if(index == 0) return nums.get(index);
		if(index < 0) return 0;

		if(dp[index] != -1) return dp[index];

		int pick = nums.get(index) + f(nums, index-2, dp);
		int notpick = 0 + f(nums, index-1, dp);

		return dp[index] = Math.max(pick, notpick); 
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		int[] dp = new int[n];

		for(int i=0;i<n;i++) dp[i] = -1;

		return f(nums, n-1, dp);
	}
}

//Tabulation: TC:O(N)  SC: O(N)
public class Maximum_Sum_of_Non_Adjacent_Elements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		int[] dp = new int[n];

		for(int i=0;i<n;i++) dp[i] = -1;
		dp[0] = nums.get(0);
		if(n > 1) dp[1] = Math.max(nums.get(1), dp[0]);

		for(int i=2;i<n;i++){

			int pick = nums.get(i) + dp[i-2];
			int notpick = 0 + dp[i-1];

			dp[i] = Math.max(pick, notpick);
		}

		return dp[n-1];
	}
}

//Space optimization: TC:O(N)  SC: O(1)
public class Maximum_Sum_of_Non_Adjacent_Elements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();

		if(n==1) return nums.get(0);

		int prev2 = nums.get(0);
		int prev = Math.max(nums.get(1), prev2);

		for(int i=2;i<n;i++){

			int pick = nums.get(i) + prev2;
			int notpick = 0 + prev;

			int curi = Math.max(pick, notpick);
			prev2 = prev;
			prev = curi;
		}

		return prev;
	}
}

