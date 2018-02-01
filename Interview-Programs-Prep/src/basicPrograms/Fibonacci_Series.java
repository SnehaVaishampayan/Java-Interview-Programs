package basicPrograms;


/*
 * Fibonacci Series = 1 1 2 3 5 8 13 21 .....
 */
public class Fibonacci_Series {

	public static void main(String[] args) {

		System.out.println(fib_recursion(2));
		System.out.println(fib_recursion(8));

		System.out.println(fib_iterative(2));
		System.out.println(fib_iterative(8));
	}

	public static int fib_recursion(int n ){
		if(n == 1 || n == 2){ // 1 1 ....First two digits in series are 1
			return 1;
		}
		else {
			return fib_recursion(n-1)+ fib_recursion(n-2);
		}
	}

	public static int fib_iterative(int n){
		if(n == 1 || n == 2){ // 1 1 ....First two digits in series are 1
			return 1;
		}
		
		int currResult = 1;
		int prevResult = 1;

		for(int i=2;i<n;i++){
			int temp = currResult;
			currResult = currResult + prevResult;
			prevResult = temp;
		}
		return currResult;
	}

}
