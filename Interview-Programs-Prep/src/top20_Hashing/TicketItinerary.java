package top20_Hashing;

import java.util.*;

//Find Itinerary from a given list of tickets

//Input:
//"Chennai" -> "Banglore"
//"Bombay" -> "Delhi"
//"Goa"    -> "Chennai"
//"Delhi"  -> "Goa"
//
//Output: 
//Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,

public class TicketItinerary {

	private static void printItinerary(Map<String, String> dataSet) {
		
		Collection<String> alldest = dataSet.values();
		
		String start = "";
		for(Map.Entry<String, String> eachEntry: dataSet.entrySet()) {
			String city = eachEntry.getKey();
			if(!alldest.contains(city)) {
				start = city;
			}
		}
		System.out.println("start " + start);
		StringBuilder result = new StringBuilder();
		String eachStop = start;
		while(dataSet.containsKey(eachStop)) {
			result.append("\n"+ eachStop + " -> ");
			eachStop = dataSet.get(eachStop);
		}
		result.append(eachStop);
		System.out.println(result);
		
	}
	public static void main(String[] args) {
	    Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Chennai", "Banglore"); 
        dataSet.put("Bombay", "Delhi"); 
        dataSet.put("Goa", "Chennai"); 
        dataSet.put("Delhi", "Goa"); 
        printItinerary(dataSet);
	}

}
