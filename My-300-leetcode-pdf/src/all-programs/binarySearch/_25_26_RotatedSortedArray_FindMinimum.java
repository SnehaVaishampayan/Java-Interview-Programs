package binarySearch;

public class _25_26_RotatedSortedArray_FindMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMin (int[] nums) {
		if(nums==null || nums.length==0)
			return -1;

		int left=0;
		int right=nums.length-1;

		while(left <= right){
			//handle duplicates .. cases like [3, 1, 3]
			while(nums[left]==nums[right] && left != right){
				left++;				
			}	

			if(nums[left] <= nums[right])
				return nums[left];

			int mid =(left + right)/2;

			if(nums[mid] >= nums[left]){
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return -1;
	}
}
