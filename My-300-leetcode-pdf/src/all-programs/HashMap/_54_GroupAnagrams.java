package HashMap;

import java.util.*;

public class _54_GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();

		// map for sortedStr - originalStr
		Map<String, List<String>> hm = new HashMap<>();

		for(String s: strs) {
			if(s != null) {
				char[] chArr = s.toCharArray();

				Arrays.sort(chArr);
				String sortedStr = String.valueOf(chArr);

				if(hm.containsKey(sortedStr)) {
					List<String> subList = hm.get(sortedStr);
					subList.add(s);
					hm.put(sortedStr, subList);
				}
				else {
					List<String> subList = new ArrayList<String>();
					subList.add(s);
					hm.put(sortedStr, subList);
				}
			}
		}

		for(Map.Entry<String, List<String>> eachEntry: hm.entrySet()) {
			result.add(eachEntry.getValue());
		}
		return result;
	}
}
