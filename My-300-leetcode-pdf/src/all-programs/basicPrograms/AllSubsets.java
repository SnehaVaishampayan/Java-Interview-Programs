package basicPrograms;

import java.util.*;

public class AllSubsets {

	public static void main(String[] args) {

		List<Integer> input = new ArrayList<>();
		input.add(6);		input.add(5); 		//input.add(4);		input.add(8);
		
		List<List<Integer>>  result_list_subsets = getAllSubsets(input);
		for(List<Integer> ll: result_list_subsets) {
			System.out.println(ll);
		}

		List<String>  result_str_substrings = getAllSubStrings("Sneha");
		for(String s: result_str_substrings) {
			System.out.println(s);
		}

		List<String>  result_str_permutations = getAllPermutations("Sneha");
		for(String s: result_str_permutations) {
			System.out.println(s);
		}
	}

	// 	***************************************************************************************************
	private static List<List<Integer>> getAllSubsets(List<Integer> input) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currSubset = new ArrayList<>();
		getAllSubsetsRecursive(input, 0, currSubset, result);
		return result;
	}

	private static void getAllSubsetsRecursive(List<Integer> input, int start, List<Integer> currSubset, List<List<Integer>> result) {

		result.add(new ArrayList<>(currSubset));
		// Add ele
		// recurse start= ptr+1
		// remove ele

		for(int i = start; i < input.size(); i++) {

			currSubset.add(input.get(i)); 
			getAllSubsetsRecursive(input, i+1, currSubset, result);
			currSubset.remove(currSubset.size()-1);
		}
	}

	//	***************************************************************************************************
	private static List<String> getAllSubStrings(String s) {
		List<String> result = new ArrayList<>();
		char[] ch = s.toCharArray();
		StringBuilder currSb = new StringBuilder();
		getAllSubstringsRecursive( ch, 0,  currSb, result);
		return result;
	}
	private static void getAllSubstringsRecursive(char[] ch,int start, StringBuilder currSb, List<String> result) {
		// add
		// recurse to ptr+1
		// remove
		result.add(currSb.toString());
		for(int i = start; i < ch.length; i++) {
			currSb.append(ch[i]);
			getAllSubstringsRecursive(ch, i + 1 , currSb, result);
			currSb.deleteCharAt(currSb.length()-1);
		}
	}

	// ***************************************************************************************************
	private static List<String> getAllPermutations(String s){

		List<String> result = new ArrayList<String>();
		getAllPermutationsRecursive(s, "",result);
		return result;
	}

	private static List<String> getAllPermutationsRecursive(String str, String eachPerm, List<String> result) {
		if (str.length() == 0) {
			result.add(eachPerm);
			return result;
		}

		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			String restOfStr = str.substring(0, i) + str.substring(i + 1);
			getAllPermutationsRecursive(restOfStr, eachPerm + currChar, result);
		}
		return result;
	}

}
