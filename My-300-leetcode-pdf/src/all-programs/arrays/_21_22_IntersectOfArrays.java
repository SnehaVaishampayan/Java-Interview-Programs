package arrays;
import java.util.*;

public class _21_22_IntersectOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
// Using HashSet (No handling duplicates - (Time O(n) Space O(n))
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet();
        Set<Integer> res = new HashSet();
        
        for(int i: nums1) {
            if(!hs.contains(i)) {
                hs.add(i);
            }
        }
        for(int i: nums2) {
            if(hs.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }	
    
// 22. Using Map – handling duplicates - faster lookup (Time O(n) Space O(n))
	public int[] intersect_22(int[] nums1, int[] nums2) {
		// populate map with num1 array // traverse another num2 array
		// decrement mapValue if num exists
		// traverse map - put values in resList

		Map<Integer, Integer> hm = new HashMap<>(); // map of num - count        
		List<Integer> resList = new ArrayList<>();

		for(int n: nums1) {
			if(hm.containsKey(n)) {
				hm.put(n, hm.get(n) + 1);
			}
			else {
				hm.put(n,1);
			}
		}
		System.out.println(hm);
		for(int n: nums2) {
			if(hm.containsKey(n)) {
				resList.add(n);
				hm.put(n, hm.get(n) - 1);
				if(hm.get(n) == 0) {
					hm.remove(n);
				}
			}
		}
		return resList.stream().mapToInt(i->i).toArray();    
	}

}
