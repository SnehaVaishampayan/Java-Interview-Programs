package binarySearch;

public class _24_SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int searchInsert(int[] nums, int target) {
    	
        int left = 0; int right = nums.length -1;
        
        while(left <= right){
        	
            int mid = (left+right)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(target < nums[mid]) { //	Move Left
                right = mid-1;                
            }
            else {
                left = mid+1;		//	Move Right
            }
        }
        return left;
    }
}
