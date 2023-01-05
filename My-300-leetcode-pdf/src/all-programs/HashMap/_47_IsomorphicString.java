package HashMap;

import java.util.*;

public class _47_IsomorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isIsomorphic(String s, String t) {

		if(s.length() != t.length()) return false;

		Map<Character, Character> hm = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			char value = t.charAt(i);

			if(hm.containsKey(key)) {
				if(hm.get(key) != value) {
					return false;
				}
			}

			else {
				if(hm.containsValue(value)) { // value is already mapped.
					return false; 
				}
				hm.put(key, value);
			}
		}
		return true;
	}
}
