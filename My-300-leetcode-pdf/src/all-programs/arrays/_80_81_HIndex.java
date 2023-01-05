package arrays;

import java.util.Arrays;

public class _80_81_HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5
//			papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since
//			the researcher has 3 papers with at least 3 citations each and the remaining two with
//			no more than 3 citations each, his h-index is 3.

	private static int hIndex(int[] citations) {
		int result = 0;
		Arrays.sort(citations);
		
		for(int i=0; i < citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length-i);
			result = Math.max(smaller, result);
		}
		return result;
		
	}
}
