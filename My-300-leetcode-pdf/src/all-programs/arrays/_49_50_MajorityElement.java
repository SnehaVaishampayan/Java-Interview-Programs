package arrays;

import java.util.*;

public class _49_50_MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int majorityElement_half(int[] nums) { // Occurred > n/2
        int majEle = nums[0];
        int count = 0;
        
        for(int n: nums){
            if(count == 0 || n == majEle) {
                majEle = n;
                count++;
            }
            else {
                count--;
            }
        }
        return majEle;
    }
    
    public List<Integer> majorityElement_oneThird(int[] nums) { 	// Occurred > n/3
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();
        for(int n: nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e: hm.entrySet()) {
            
            if(e.getValue() > nums.length/3) {
                result.add( e.getKey());
            }
        }
        return result;
    }
}
