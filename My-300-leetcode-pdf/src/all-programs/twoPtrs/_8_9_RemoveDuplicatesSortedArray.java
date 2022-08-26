package twoPtrs;

public class _8_9_RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        
        // Remove in-place
        // Copy new lenght of unque int[]
        
        int prev = 0;
        int curr = 1;
        
        while(curr < nums.length) {
            
            if(curr < nums.length && nums[prev] == nums[curr]) {
                curr++;
            }
            else {  
                prev++;
                nums[prev] = nums[curr];                
                curr++;
            }
        }
        return prev+1;
    }
    
    public int removeDuplicates_TwiceAllowed(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        
        int prev = 1;
        int curr = 2;
        
        while(curr < nums.length) {
            if(nums[prev] == nums[curr] && nums[prev-1] == nums[curr]) {
                curr++;
            }
            else {
                prev++;
                nums[prev] = nums[curr];
                curr++;
            }
        }
        return prev+1;
    }

}
