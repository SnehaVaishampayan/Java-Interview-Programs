package basicPrograms;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(fact_recursive(5));

		System.out.println(fact_iterative(5));

	}
	
	public static int fact_recursive(int n){
		if(n<=0){
			return 1;
		}
		return fact_recursive(n-1) * n;
	}
	
	public static int fact_iterative(int n) {
		if(n <= 0) {
			return 1;
		}
		int result = 1;
		for(int i=1; i<=n; i++) {
			result = result * i;
		}
		return result;
	}
}
