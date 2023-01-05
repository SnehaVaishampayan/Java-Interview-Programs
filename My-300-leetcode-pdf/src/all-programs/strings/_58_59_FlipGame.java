package strings;

import java.util.*;

public class _58_59_FlipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> generatePossibleNextMoves(String currentState) {
		List<String> result = new ArrayList<>();

		for(int i = 1; i < currentState.length(); i++) {
			// Consecutive ++
			if(currentState.charAt(i-1) == '+' && currentState.charAt(i) == '+') { 

				// substring excludes endIndex. 
				result.add(currentState.substring(0, i-1) + "--" + currentState.substring(i+1,currentState.length())); 
			}
		}

		return result;
	}
	public boolean canWin(String s) {
		
		for(int i = 1; i < s.length(); i++) {
			// Consecutive ++
			if(s.charAt(i-1) == '+' && s.charAt(i) == '+') { 
				// substring excludes endIndex. 
				String t = s.substring(0, i-1) + "--" + s.substring(i+1,s.length()); 

				if (!canWin(t)) 	//To check can win. 
					return true;				
			}
		}
		return false;
	}
}
