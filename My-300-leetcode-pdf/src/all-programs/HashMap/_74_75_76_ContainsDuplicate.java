package HashMap;

import java.util.*;

public class _74_75_76_ContainsDuplicate {

	public static void main(String[] args) {
		int[] input = {3,5,6,2,3,6,9,4};
		System.out.println(containsDuplicate(input));

	}
	public static boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return false;
		}
		Set<Integer> hs = new HashSet<>();
		for(int i: nums){
			if(hs.contains(i)) {
				return true;
			}
			hs.add(i);
		}
		return false;
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				int pre = map.get(nums[i]);
				if(i-pre<=k)
					return true;
			}
		}
		return false;
	}
}