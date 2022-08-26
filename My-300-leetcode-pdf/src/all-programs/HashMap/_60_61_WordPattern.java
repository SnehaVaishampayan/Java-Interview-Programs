package HashMap;

import java.util.*;

public class _60_61_WordPattern {

	//	pattern = "abab", str = "redblueredblue
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean wordPattern(String pattern, String s) {
		// match char to word
		Map<Character, String> hm = new HashMap<>();
		String[] arr = s.split(" ");
		char[] charr = pattern.toCharArray();
		if(arr.length != charr.length) {
			return false;
		}
		for(int i = 0 ; i < arr.length; i++) {
			char c = charr[i];
			String word = arr[i];
			if(hm.containsKey(c)) {
				if(!hm.get(c).equals(word)) {
					return false;
				}
			}
			else if(hm.containsValue(word)) {
				return false;
			}
			else {
				hm.put(c, word);
			}
		}
		return true;
	}
}
