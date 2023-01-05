package binarySearch;

public class _28_GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int guessNumber(int n) {
		int left = 0; int right = n;
		while(left <= right) {
			int mid = left+ ((right-left)/2);
			int g = 5;// guess(mid);
			if(g == 0) return mid;
			else if(g == 1) {
				left = mid+ 1 ;
			}
			else {
				right = mid-1;
			}
		}
		return -1;
	}
}
