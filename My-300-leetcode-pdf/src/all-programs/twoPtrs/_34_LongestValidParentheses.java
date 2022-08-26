package twoPtrs;

import java.util.Stack;

public class _34_LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int longestValidParentheses(String s) {

		// Scan Left -> Right.. Count openBraces/ closedBraces..
		// openBraces == closedBraces .. res = max(res, openBraces+closedBraces)
		int openBraces = 0; int closedBraces = 0; int result = 0;
		for(int i = 0; i < s.length(); i++) { //   Scan Left -> Right
			if(s.charAt(i) == '(') 
				openBraces++;
			else 
				closedBraces++;
			if(openBraces == closedBraces) 
				result = Math.max(result, openBraces + closedBraces);
			else if(closedBraces >= openBraces) 
				openBraces = closedBraces = 0;
		}
		
		
		// Scan Right-> Left.. Count openBraces/ closedBraces..
		// openBraces == closedBraces .. res = max(res, openBraces+closedBraces)
		openBraces = 0;  closedBraces = 0;
		for(int i = s.length()-1; i >=0; i--) { //   Scan Left -> Right
			if(s.charAt(i) == '(') 
				openBraces++;
			else 
				closedBraces++;
			if(openBraces == closedBraces) 
				result = Math.max(result, openBraces + closedBraces);
			else if(openBraces >= closedBraces ) 
				openBraces = closedBraces = 0;
		}            
		return result;
	}
}
