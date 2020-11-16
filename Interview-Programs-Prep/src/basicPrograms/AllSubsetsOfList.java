package basicPrograms;

import java.util.*;

public class AllSubsetsOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> input = new ArrayList<>();
		input.add(6);		input.add(5); 		//input.add(4);		input.add(8);
		List<List<Integer>>  res = getAllSubsets(input);
		for(List<Integer> ll: res) {
			System.out.println(ll);
		}
	}

	private static List<List<Integer>> getAllSubsets(List<Integer> input) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currSubset = new ArrayList<>();
		getAllSubsetsRecursive(input, 0, currSubset, result);
		return result;
	}

	private static void getAllSubsetsRecursive(List<Integer> input, int currListPtr, List<Integer> currSubset, List<List<Integer>> result) {
//		if(currListPtr == input.size()) {
//			result.add(new ArrayList<>(currSubset));
//			return;
//		}
		result.add(new ArrayList<>(currSubset));		
		for(int i = currListPtr; i < input.size(); i++) {
			currSubset.add(input.get(i));
			getAllSubsetsRecursive(input, i+1, currSubset, result);
			currSubset.remove(currSubset.size()-1);
		}
	}
}
