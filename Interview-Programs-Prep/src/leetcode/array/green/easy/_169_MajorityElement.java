package leetcode.array.green.easy;

public class _169_MajorityElement {

	public static void main(String[] args) {
		int[] input = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(input));

	}
    private static int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        
        for(int n: nums) {
            if(count == 0) {        // initially or two ele equally present.. 2 2 5 5 here 4
                majorityElement = n; 
                count = 1; 
            }
            else if ( n == majorityElement) {
                count++;
            }
            else {
                count--;
            }
        }
        return majorityElement;
    }


}
