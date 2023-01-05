package basicPrograms;

import java.util.*;

public class Map_EntrySet {
	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<>();
		
		populateMap(hm);
		printKeyValues(hm);
	
	}

	private static void printKeyValues(Map<String, Integer> hm) {
		for(Map.Entry<String, Integer> eachEntry: hm.entrySet()) {
			
			System.out.println("Each Key " + eachEntry.getKey());
			System.out.println("Each Value " + eachEntry.getValue());
		}
	}

	private static void populateMap(Map<String, Integer> hm) {
		hm.put("key1", 1);hm.put("key2", 2);hm.put("key3", 3);hm.put("key4", 4);		
	}	
}
