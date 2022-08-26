package arrays;

public class _51_IncreasingTripletSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean increasingTriplet(int[] nums) {
		
		// small mid big
		int small = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;

		for(int curr :nums) {
			if(curr <= small) { // this is the smallest so far
				small = curr;
			}
			else if(curr <= mid) { // curr > small but <= mid.. 
				mid = curr;
			}
			// curr > small and curr > mid
			// that means all three are assigned with curr largest num
			else {
				return true; 
			}
		}
		return false;
	}
}
