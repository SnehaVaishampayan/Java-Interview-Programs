package HashMap;
import java.util.*;

public class _40_GroupingStrSameShifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupStrings(String[] inputStrArr) {        
		List<List<String>> result = new ArrayList<>();

		Map<String, List<String>> hm = new HashMap<>();

		for(String s: inputStrArr) {
			String key = "";
			if(s == null|| s.length() <= 0) {
				continue;
			}

			char[] arr = s.toCharArray();

			for(int i = 1; i < s.length(); i++)  {
				int offset = s.charAt(i) - s.charAt(i-1);

				if( offset < 0) {
					offset = offset + 26; // Rounding if chars in descending order					
				}
				key += offset+",";                
			}

			if(!hm.containsKey(key)) {
				hm.put(key, new ArrayList<String>());				
			}

			List<String> value = hm.get(key);
			value.add(s);
			hm.put(key, value);
		}

		for(List<String> ss: hm.values()) {
			Collections.sort(ss);
			result.add(ss);
		}
		return result;
	}
}
