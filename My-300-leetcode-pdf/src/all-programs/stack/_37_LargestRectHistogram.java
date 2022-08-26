package stack;

import java.util.Stack;

public class _37_LargestRectHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int largestRectangleArea(int[] heights) {
        
        // Traversing trhogh the heights
        // if currValue >= top
        //        Add INDEX to stack
        // else 
        //      while currValue < top
        //      calc currArea = heights[top] * (i - top - 1);
        
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        
        for (int i = 0; i < heights.length; ++i) {
            
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) 
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
}
