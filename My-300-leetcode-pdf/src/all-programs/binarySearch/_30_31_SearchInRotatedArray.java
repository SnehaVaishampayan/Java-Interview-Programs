package binarySearch;

public class _30_31_SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int search(int[] nums, int target) {

		return recbinSearch(nums, 0, nums.length-1, target);

	}

	public int recbinSearch(int[] nums, int start, int end, int target ) {
		int mid = (start+end)/2;
		if( target == nums[mid]) {
			return mid;
		}
		if( start > end) {
			return -1;
		}

		// if left normally sorted, 
		if(nums[start] < nums[mid]) {
			// start -- target -- mid-1
			if( nums[start] <= target && target < nums[mid]) {

				return recbinSearch(nums, start, mid-1, target);
			}
			else {
				return recbinSearch(nums, mid + 1, end, target);                
			}
		}

		// if right normally sorted, 
		else if ( nums[start] > nums[mid]) {
			// mid+1 -- target -- end
			if( nums[mid] < target && target <= nums[end]) {
				return recbinSearch(nums, mid+1, end, target);
			}
			else {
				return recbinSearch(nums, start, mid-1, target);
			}
		}

		// repeated nums
		else if (nums[start] == nums[mid]){ //left repeated
			// left repeated right diff
			if(nums[mid] != nums[end]) {
				// search right
				return recbinSearch(nums, mid+1, end, target);                
			}
			else {
				// search both sides
				int result =  recbinSearch(nums, start, mid-1, target);
				if(result == -1) {
					return recbinSearch(nums, mid+1, end, target);
				}
				else {
					return result;
				}
			}
		}
		return -1;        
	}
}
