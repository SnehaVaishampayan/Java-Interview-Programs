package strings;

public class validPalindrome {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abc"));

	}
	public static boolean validPalindrome(String s) {  int start = 0; 
	int end = s.length()-1;

	while(start < end){
		if(s.charAt(start) != s.charAt(end)) {
			return (paliRec(s, start, end+1) || paliRec(s, start-1, end));
		}
		start++;
		end--;
	}
	return true;
	}
	public static boolean paliRec(String s, int start, int end){

		while(start < end){
			start++;
			end--;
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}

		}
		return true;
	}
}