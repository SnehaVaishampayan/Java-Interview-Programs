package twoPtrs;

public class _12_ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	public int maxArea(int[] height) {
		int result = 0;

		int left = 0 ;
		int right = height.length - 1;

		while(left < right) {
			result = Math.max(result, ( (right-left) * Math.min(height[left], height[right])));

			// Move ahead.. next iteration
			if(height[left] < height[right]) {
				left++;
			}
			else {
				right--;
			}
		}

		return result;
	}

}
