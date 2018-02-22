package strings;

import java.util.Stack;

public class validParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {

		// validations
		if (s == null || s.length() < 2 || (s.length() % 2) != 0) {
			System.out.println("lk");
			return false;
		}


		Stack<Character> st = new Stack<Character>();

		for(char c: s.toCharArray()){
			if(c =='(')
				st.push(')');
			else if(c == '{')
				st.push('}');
			else if(c == '[')
				st.push(']');
			else if(st.isEmpty() || st.pop() != c )

				return false;
		}
		return st.isEmpty();
	}
}
