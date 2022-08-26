package stack;
import java.util.Stack;

public class _36_MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	private Stack<int[]> minStack;

	public _36_MinStack() {
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		// if minStack empty.. then val = firstEle

		if(minStack.isEmpty()) {
			minStack.push(new int[] {val, val});
			return;
		}
		int currMin = minStack.peek()[1];
		minStack.push(new int[] {val, Math.min(val, currMin)});
	}

	public void pop() {
		minStack.pop();
	}

	public int top() {
		return minStack.peek()[0];
	}

	public int getMin() {
		return minStack.peek()[1];
	}
}
