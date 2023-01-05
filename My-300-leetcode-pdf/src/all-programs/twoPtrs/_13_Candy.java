package twoPtrs;

public class _13_Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int candy(int[] ratings) {
        // Iterate left to right
        //      if prev > curr          NOT ASCENDING
        //          curr = curr  + 1
        //      else 
        //          curr = 1
        
        // Iterate from right to left
        //      if prev > curr  // i > (i+1)
        //          currHelperCount = prev + 1
        //       
        //      result = Math.max(prevHelperCount, currHelperCount)
        //      
        
        int[] helperArr = new int[ratings.length];
        helperArr[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1] ) {
                helperArr[i] = helperArr[i-1] + 1;
            }
            else {
                helperArr[i] = 1;
            }
        }
        
        int result = helperArr[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; i--) {
            
            int helperPrevCount = helperArr[i];
            if(ratings[i] > ratings[i+1]) {
                helperArr[i] = helperArr[i+1] + 1;
            }
            else {
                helperArr[i] = 1;
            }
            result = result + Math.max(helperPrevCount, helperArr[i]); // Max of helperPrevCount and helperCurrCount

        }
        
        return result;
    }

}
