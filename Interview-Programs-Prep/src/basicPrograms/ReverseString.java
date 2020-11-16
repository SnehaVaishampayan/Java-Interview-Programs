package basicPrograms;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ReverseString {	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int numTestCases = sc.nextInt();
		while(numTestCases > 0) {
			System.out.println(getReversedString(sc.next()));
			numTestCases--;
		}
	}

	private static String getReversedString(String s) {
		if(s== null || s.length() <= 1) {
			return s;
		}

		int end = s.length()-1;
		
		char[] chArr = new char[s.length()];
		int arrItr = 0;
		
		while(end >=0) {
			chArr[arrItr] = s.charAt(end);
			end--;
			arrItr++;
		}
		return new String(chArr);

	}
}