package basicPrograms;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		for(int i=0; i < 100; i++) {
			if(getPrimeNumbers(i)) {
				System.out.println(i);
			}
		}
	}
	
	// O(n)	
	private static boolean getPrimeNumbers(int n) {
		if( n <= 0) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		for(int i= 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
