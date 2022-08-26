package HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_6_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("bjkkjk");
	}


	public List<List<Integer>> threeSum(int[] nums) {        

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		if(nums.length < 3 ) {
			return result;
		}

		for(int p1 = 0; p1 < nums.length - 2; p1++) {
			int p2 = p1 + 1;
			int p3 = nums.length - 1;

			int sum = nums[p1] + nums[p2] + nums[p3];

			while( p2 < p3) {
				if(sum == 0) {
					List<Integer> subResult = new ArrayList<>();
					subResult.add(nums[p1]);subResult.add(nums[p2]);subResult.add(nums[p3]);
					result.add(subResult);	
					p2++;
					p3--;

					while(p2 < p3 && nums[p2-1] == nums[p2] ) {
						p2++;
					}
					while(p2 < p3 &&  nums[p3] == nums[p3+1]) {
						p3--;
					}
				}
				else if (sum < 0){
					p2++;
				}
				else {
					p3--;
				}
			}
		}

		return result;
	}


	public int threeSumClosest(int[] nums, int target) {

		int resultSum = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		// Sort an array
		// mark p1
		// iterate thru the array .. left - right
		// sum = p1 + left + right
		//  if sum == 0 return sum
		//  if diff < currDiff.. reassign
		//  if sum< target.. left== else right--;

		Arrays.sort(nums);
		for(int p1 = 0 ; p1 < nums.length - 2; p1++) {

			int left = p1 +1;
			int right = nums.length-1;

			while(left < right) {
				int sum = nums[p1] + nums[left] + nums[right];

				int currDiff = Math.abs(sum - target);

				if(currDiff == 0) {
					return sum;
				}

				if(currDiff < diff) {
					diff = currDiff;
					resultSum = sum;
				}

				if( sum < target) {
					left++;
				}
				else {
					right--;
				}

			}
		}
		return resultSum;
	}
}    

