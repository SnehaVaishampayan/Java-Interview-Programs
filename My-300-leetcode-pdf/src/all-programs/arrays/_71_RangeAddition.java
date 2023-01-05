package arrays;

public class _71_RangeAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] result = new int[length];

		// iterating updates.. 
		// at start add value.. 
		// at end .. minus value

		// 					0 0 0 0 0  0 
		// 1 5 2			0 2 0 0 0  0
		// 2 4 3 			0 2 3 0 0 -3
		// 0 2 -2		   -2 2 3 2 0 -3

		// oldVal + prev	-2 0 3 5 5 2


		for(int[] eachUpdate: updates) {
			int start = eachUpdate[0];
			int end = eachUpdate[1];
			int value = eachUpdate[2];


			if(start < length) {
				result[start] = result[start] + value;
			}
			if(end+1 < length) {
				result[end+1] = result[end+1] - value;
			}
		}


		for(int i = 1; i < length; i++) {
			int oldVal = result[i];
			result[i] = result[i-1] + oldVal;  // ************ 
		}
		return result;	
	}
}
