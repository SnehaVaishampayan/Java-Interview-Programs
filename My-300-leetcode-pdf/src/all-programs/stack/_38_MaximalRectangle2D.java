package stack;
import java.util.Stack;

public class _38_MaximalRectangle2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return -1;
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols+1];

		for(int r = 0 ; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				if(matrix[r][c] == '0') {
					dp[r][c] = 0;
				}
				else {
					// first row 0.. else add 1 to prev
					dp[r][c] = (r == 0) ? 1 : dp[r-1][c] + 1; 
				}
			}
		}
		int resultArea = 0;
		int currMaxHistogramArea = 0;

		for(int[] eachRow: dp) {
			currMaxHistogramArea = getMaxAreaInHistogram(eachRow);
			resultArea = Math.max(resultArea, currMaxHistogramArea);
		}
		return resultArea;
	}

	public int getMaxAreaInHistogram(int[] eachRow) {
		int result = 0;
		int n = eachRow.length;
		Stack<Integer> hs = new Stack<Integer>();
		hs.push(-1);

		for(int i = 0; i < eachRow.length; ++i) {

			while(hs.peek() != -1 && eachRow[hs.peek()] >= eachRow[i] )              
				result = Math.max(result, eachRow[hs.pop()] * (i - hs.peek() - 1));
			hs.push(i);
		}
		while(hs.peek() != -1) { 
			result = Math.max(result, eachRow[hs.pop()] * (n - hs.peek() - 1));
		}
		return result;
	}

}
