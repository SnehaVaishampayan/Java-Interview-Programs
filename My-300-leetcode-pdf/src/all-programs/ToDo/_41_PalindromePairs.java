package ToDo;

import java.util.*;

// *******  HARD
public class _41_PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> palindromePairs(String[] words) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<words.length; i++){
			map.put(words[i], i);
		}        
		for(int i=0; i<words.length; i++){
			String s = words[i];
			//if the word is a palindrome, get index of ""
			if(isPalindrome(s)){
				if(map.containsKey("")){
					if(map.get("")!=i){
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(i);
						l.add(map.get(""));
						result.add(l);
						l = new ArrayList<Integer>();
						l.add(map.get(""));
						l.add(i);
						result.add(l);
					}
				}
			}

			//if the reversed word exists, it is a palindrome
			String reversed = new StringBuilder(s).reverse().toString();
			if(map.containsKey(reversed)){        
				if(map.get(reversed)!=i){
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(map.get(reversed));
					result.add(l);
				}
			}        
			for(int k=1; k<s.length(); k++){
				String left = s.substring(0, k);
				String right= s.substring(k);
				//if left part is palindrome, find reversed right part
				if(isPalindrome(left)){
					String reversedRight = new
							StringBuilder(right).reverse().toString();
					if(map.containsKey(reversedRight)){
						if(map.get(reversedRight)!=i){
							ArrayList<Integer> l = new ArrayList<Integer>();
							l.add(map.get(reversedRight));
							l.add(i);
							result.add(l);
						}
					}
				}        
				//if right part is a palindrome, find reversed left part
				if(isPalindrome(right)){
					String reversedLeft = new
							StringBuilder(left).reverse().toString();
					if(map.containsKey(reversedLeft)){
						if(map.get(reversedLeft)!=i){
							ArrayList<Integer> l = new ArrayList<Integer>();
							l.add(i);
							l.add(map.get(reversedLeft));
							result.add(l);
						}
					}
				}
			}
		}
		return result;
	}        
	public boolean isPalindrome(String s) {
		System.out.println("ss "+ s);
		int left = 0; int right = s.length()-1;

		while(left<=right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
