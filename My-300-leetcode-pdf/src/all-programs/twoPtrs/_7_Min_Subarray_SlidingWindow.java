package twoPtrs;

public class _7_Min_Subarray_SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minSubArrayLen(int target, int[] nums) {

		if(nums == null || nums.length == 0) {
			return 0;
		}

		int result = nums.length;
		int resStart = 0;
		int resEnd = 0;
		int sum = 0;

		boolean exists = false;

		while(resEnd <= nums.length) {
			if(sum >= target ){
				exists = true;

				if( resStart == resEnd-1) {
					return 1;
				}
				result = Math.min(result, resEnd - resStart);
				sum = sum - nums[resStart]; 
				resStart++;
			}
			else {
				if(resEnd == nums.length) {
					break;
				}
				sum = sum + nums[resEnd];
				resEnd++;
			}            
		}

		if (exists) {
			return result;
		}
		else {
			return 0;
		}
	}
}
