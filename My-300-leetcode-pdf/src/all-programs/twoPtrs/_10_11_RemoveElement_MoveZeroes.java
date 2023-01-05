package twoPtrs;

public class _10_11_RemoveElement_MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int resItr = 0;
        int curr = 0;
        
        while(curr < nums.length) {
            if(nums[curr] == val) {		// OR zero
                curr++;
            }
            else {
                nums[resItr] = nums[curr];
                resItr++;
                curr++;
            }
        }
        
// For val = 0, make leftover resItr.. toEnd(nums.length) elements = zero
        
//        while( resItr < nums.length) {
//        	nums[resItr] = 0;
//        	resItr++;
//        }  
        return resItr;
    }

}
