import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public List<List<Integer>> permute(int index, int[] nums,List<List<Integer>> ans){

        if(index == nums.length-1){
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<nums.length;i++) ls.add(nums[i]);
            ans.add(ls);
            return ans;
        }

        for(int i=0;i<nums.length;i++){
            swap(i,index,nums);
            permute(index+1, nums, ans);
            swap(i,index,nums); 
        }
        return ans;
    }

    public void swap(int i,int index, int[] nums){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public void permutation(int[] nums){
        
        List<List<Integer>> ans = new ArrayList<>();

        ans = permute(0,nums,ans);

        System.out.print(ans);
    }
}

public class permutation {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = i+1;
        
        Solution solution = new Solution();
        solution.permutation(nums);
    }
}
