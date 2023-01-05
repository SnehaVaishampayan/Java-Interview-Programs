package twoPtrs;

public class _14_TrappingWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        
        int left = 0; 
        int right = height.length - 1;
        
        int leftMax = 0, rightMax = 0;
        
        int result = 0;
        
        while(left < right) {
        	
        	// Reassign leftMax
            if(height[left] > leftMax) {
                leftMax = height[left];
            }
        	// Reassign rightMax
            if(height[right] > rightMax) {
                rightMax = height[right];
            }
            
            // Add water trapped till now 
            if(leftMax < rightMax) {
                result = result + Math.max(0, leftMax-height[left]);
                left++;
            }
            else {
                result = result + Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return result;
    }
}
