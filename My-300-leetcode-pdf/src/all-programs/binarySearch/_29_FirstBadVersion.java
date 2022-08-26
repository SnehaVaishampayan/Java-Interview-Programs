package binarySearch;

public class _29_FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int firstBadVersion(int n) {
		int left  = 1; int right  = n;
		while(left < right){
			int mid = left + (right - left) / 2;
			if(true) { // if(isBadVersion(mid)){
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return left;

	}
}
