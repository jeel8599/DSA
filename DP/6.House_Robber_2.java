import java.util.*;

// same as 5th problem little bit modification 

public class House_Robber_2 {
    public static long maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();

		if(n==1) return nums.get(0);

		long prev2 = nums.get(0);
		long prev = Math.max(nums.get(1), prev2);

		for(int i=2;i<n;i++){

			long pick = nums.get(i) + prev2;
			long notpick = 0 + prev;

			long curi = Math.max(pick, notpick);
			prev2 = prev;
			prev = curi;
		}

		return prev;
	}

	public static long houseRobber(int[] valueInHouse) {

		int n = valueInHouse.length;
		if(n == 1) return valueInHouse[0];

		ArrayList<Integer> ls1 = new ArrayList<>();
		ArrayList<Integer> ls2 = new ArrayList<>();

		for(int i=0;i<n;i++){
			if(i != 0) ls1.add(valueInHouse[i]);
			if(i != n-1) ls2.add(valueInHouse[i]);
		}

		return Math.max(maximumNonAdjacentSum(ls1), maximumNonAdjacentSum(ls2));
	}
}
