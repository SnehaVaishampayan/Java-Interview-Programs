package strings;

import java.util.*;

public class _43_LongestSSWithoutRepeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int lengthOfLongestSubstring(String s) {
		// map track char - index
		Map<Character, Integer> hm = new HashMap<>();
		int startIndex = 0; int result = 0;
        
		for(int end = 0; end < s.length(); end++ ){
			char ch = s.charAt(end);
			if(hm.containsKey(ch)) {
				startIndex = Math.max(hm.get(ch), startIndex);                
			}
			hm.put(ch, end+1);
			result = Math.max(result, end - startIndex + 1);
		}
		return result;
	}
}
