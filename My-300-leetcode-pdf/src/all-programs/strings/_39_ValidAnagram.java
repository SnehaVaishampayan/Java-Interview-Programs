package strings;

import java.util.*;

public class _39_ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean validAnagram_areStringsAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		boolean result = false;
		Map<Character, Integer> hm = new HashMap<>();
		for(char c: s.toCharArray()) {
			if(!hm.containsKey(c)) {
				hm.put(c, 1);
			}
			else {
				hm.put(c, hm.get(c) + 1);
			}
		}

		for(char c: t.toCharArray()) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c) - 1);
				if(hm.get(c) == 0) {
					hm.remove(c);
				}
			}
			else {
				return false;
			}
		}
		return true;	
	}


}
