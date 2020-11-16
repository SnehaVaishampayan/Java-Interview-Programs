package top20_Hashing;

import java.util.*;

public class IsArraySubset {
//	Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
//	Output: True
//	Explanation: arr2[] is a subset of arr1[]
	
	
	private static boolean isSubset(int[] arr, int[] subsetArr) {
		
		Map<Integer,Integer> arrFreqMap = new HashMap<>();
		
		for(int i: arr) {
			if(arrFreqMap.containsKey(i)) {
				arrFreqMap.put(i, arrFreqMap.get(i) + 1);
			}
			else {
				arrFreqMap.put(i, 1);
			}
		}
		
		for(int i: subsetArr) {
			if(arrFreqMap.containsKey(i)) {
				arrFreqMap.put(i, arrFreqMap.get(i)-1);
				int count = arrFreqMap.get(i);
				if(count < 0 ) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,6,3,1};
		int[] s = {4,2,2};
		System.out.println(isSubset(a, s));

		int[] aa = {2,4,6,3,1};
		int[] ss = {8,2};
		System.out.println(isSubset(aa, ss));
	}

}
