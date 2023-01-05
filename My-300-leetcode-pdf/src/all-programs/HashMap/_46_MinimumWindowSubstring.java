package HashMap;

import java.util.*;

public class _46_MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// https://www.youtube.com/watch?v=U1q16AFcjKs

	public String minWindow(String s, String t) {
		if(s.length() < t.length() ) {
			return "";
		}

		// t string Char freq map
		Map<Character, Integer> tFreqMap = new HashMap<>();
		for(char c: t.toCharArray()) {
			tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
		}

		int resMinLen = s.length()+1;
		int start = 0; int end = 0; 

		String res = "";
		int charsFound = 0;

		Map<Character, Integer> wm = new HashMap<>();
		for( end = 0; end < s.length(); end++) {
			char endCh = s.charAt(end);

			if(tFreqMap.containsKey(endCh)) {
				if(wm.containsKey(endCh)) {
					if(wm.get(endCh) < tFreqMap.get(endCh) ) {
						charsFound++;
					}                    
					wm.put(endCh, wm.get(endCh) + 1);
				}
				else {
					wm.put(endCh, 1);
					charsFound++;
				}
			}
			if(charsFound == t.length()) { // all chars found

				// Shrink the substring 
				char startCh = s.charAt(start);
				while(!wm.containsKey(startCh) || wm.get(startCh) > tFreqMap.get(startCh)) {
					if(wm.containsKey(startCh) && wm.get(startCh) > tFreqMap.get(startCh)) {
						wm.put(startCh, wm.get(startCh) - 1); // decrement count
					}
					start++;
					startCh = s.charAt(start);
				}

				if((end - start + 1 ) < resMinLen) {
					resMinLen = end - start + 1;
					res = s.substring(start, end+1);
				}
			}       
		}
		return res;
	}

}