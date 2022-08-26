package arrays;

import java.util.*;

public class _48_LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        
        for(int n : nums) {
            hs.add(n);
        }
        
        int resLen = 0;
        
        for(int num : hs) {
            if(!hs.contains(num-1)) {            
                int currNum = num;
                int currLen = 1;
                while(hs.contains(currNum+1)) {
                    currLen++;
                    currNum++;
                }
                resLen = Math.max(resLen, currLen);
            }
        }
        
        return resLen;
    }
}
