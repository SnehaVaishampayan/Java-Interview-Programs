package stack;

import java.util.Stack;

public class _32_EvaluateReversePolishNotationEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int evalRPN(String[] tokens) {

		// digitStack - if symbol.. pop to digits.. operate .. push in stack

		String symbols = "+-*/";
		Stack<String> digitStack = new Stack<>();   

		for(String s: tokens) {
			// if digits
			if(!symbols.contains(s)) {
				digitStack.push(s);
			}
			else {

				// operator.. so operate
				int num1 = Integer.valueOf(digitStack.pop());
				int num2 = Integer.valueOf(digitStack.pop());

				if(s.equals("+")) {
					digitStack.push(String.valueOf(num1+num2));
				}
				if(s.equals("-")) {
					digitStack.push(String.valueOf(num2-num1));
				}
				if(s.equals("*")) {
					digitStack.push(String.valueOf(num1*num2));
				}
				if(s.equals("/")) {
					digitStack.push(String.valueOf(num2/num1));
				}                
			}            
		}
		return Integer.valueOf(digitStack.pop());
	}
}
