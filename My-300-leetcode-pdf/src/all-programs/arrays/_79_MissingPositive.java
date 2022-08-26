package arrays;

public class _79_MissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int firstMissingPositive(int[] nums) {
		// check for null and len == 0
		if(nums == null || nums.length == 0) {
			return 1;
		}
		if(nums.length == 1 && nums[0] == 1) {
			return 2;
		}
		// 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
		// (we can ignore those because if all number are > n then we'll simply return 1)        
		int res = 0;

		for(int i = 0; i < nums.length; i++) {

			if(nums[i] <= 0 || nums[i] > nums.length ) {
				nums[i] = nums.length + 1;                
			}
		}
		// 2. mark each cell appearing in the array, by converting the index for that number to negative        
		for(int i=0; i < nums.length; i++) {

			int index = Math.abs(nums[i]);

			if(index > nums.length) {
				continue;
			}

			index--;  // reduce for zero based index.
			if(nums[index] > 0) {
				nums[index] = -1 * nums[index];                
			}
		}

		// 3. find the first cell which isn't negative (doesn't appear in the array)        
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= 0) {
				return i + 1;
			}
		}

		// 4. no positive numbers were found, which means the array contains all numbers 1..n    
		return nums.length + 1;
	}       
}
