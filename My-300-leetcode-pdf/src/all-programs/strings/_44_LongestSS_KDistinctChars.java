package strings;

import java.util.*;

public class _44_LongestSS_KDistinctChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		if(s.length() < k) {
			return s.length();
		}
		int start = 0;
		int result = 1;
		Map<Character, Integer> hm = new HashMap<>();

		for(int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			// map 
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c,1);
			}

			if(hm.size() > k) {
				result = Math.max(result, end-start);

				while(hm.size() > k) { 
					char ch = s.charAt(start);
					// remove char at start and move start
					if(hm.get(ch) == 1) {
						hm.remove(ch);
					}
					else {
						hm.put(ch, hm.get(ch) - 1);
					}
					start++;
				}

			}
		}
		return Math.max(result, s.length()-start);
	}
}
