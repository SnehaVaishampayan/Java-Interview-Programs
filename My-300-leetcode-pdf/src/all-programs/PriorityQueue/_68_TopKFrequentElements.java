package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _68_TopKFrequentElements {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(4);input.add(64);input.add(14);input.add(84);input.add(49);input.add(58);

		// Inbuilt comparator
		List<Integer> top_k_lele = getTopKFrequentElements(input, 2);
		for(int i: top_k_lele) {
			System.out.println(i);
		}

		// Custom comparator
		String[] inputStrArray = {"Mango", "Banana", "Banana","Banana", "Pear",  "Pear", "Strawberry", "Strawberry", "Orange", "Orange", "Orange", };
		List<String> top_k_words = getTopKFreqEle_Custom(inputStrArray, 3);
		for(String eachWord: top_k_words) {
			System.out.println(eachWord);
		}
	}
	
	
	
	private static List<Integer> getTopKFrequentElements(List<Integer> input, int k) {
		List<Integer> result = new ArrayList<>();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int n: input) {
			maxHeap.add(n);
		}

		while(k > 0) {
			result.add(maxHeap.poll());
			k--;
		}
		return result;
	}
	
	private static List<String> getTopKFreqEle_Custom(String[] inputStrArray, int k) {

		List<String> result = new ArrayList<>();

		// 1. Custom priority queue comparator
		PriorityQueue<Word> word_pq = new PriorityQueue<Word>( new Comparator<Word>() {			
			@Override
			public int compare(Word w1, Word w2) {
				if (w1.count > w2.count ) {
					return -1;					// 1 for bottom least elements 
				}
				else {
					if (w1.count < w2.count) { 
						return 1; 			// -1 for bottom least elements 
					}
					else {
						return -(w1.s.compareTo(w2.s));  // reverse..   
					}
				}
			}
		} );

		// 2. Create a HashMap for keeping word count
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		for(String eachWord: inputStrArray) 
			wordCountMap.put(eachWord, wordCountMap.getOrDefault(eachWord, 0) + 1);

		// 3. Populate priority queue
		for(Map.Entry<String, Integer> eachEntry: wordCountMap.entrySet()) {
			String eachWord = (String) eachEntry.getKey();
			int count = (int) eachEntry.getValue();
			Word w = new Word(eachWord, count);
			word_pq.add(w);
		}
		while (k > 0) {
			result.add(word_pq.poll().s);
			k--;
		}
		return result;
	}
}
class Word {
	String s;
	int count;
	public Word(String s, int count) {
		this.s = s;
		this.count = count;
	}
}

