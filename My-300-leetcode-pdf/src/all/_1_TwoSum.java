package all;


import java.util.*;

public class _1_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] unsortedTwoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int  i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                res[0] = hm.get(nums[i]);
                res[1] = i;
                return res;
            }
            else {
                hm.put(target-nums[i], i);
            }
        }
        return res;
    } 
    
    public int[] sortedTwoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0; int right = nums.length-1;
        
        while(left <= right) {
            int currSum = nums[left] + nums[right];
            if(currSum == target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
            else if(currSum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
	
}
