package arrays;

public class _52_RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void rotateArray(int[] nums, int k) {
        if( k > nums.length){
            k = k % nums.length; // 5 % 3 = 2
        }
        
        reverse(nums, 0, nums.length-k-1); // firstPartEnd = nums.length - k - 1;
        reverse(nums, nums.length - k , nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
