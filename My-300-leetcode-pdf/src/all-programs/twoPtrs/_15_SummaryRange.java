package twoPtrs;
import java.util.*;

public class _15_SummaryRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();
        
        if(nums.length == 0) {
            return result;
        }
        
        for(int firstEleItr, lastEleItr = 0; lastEleItr < nums.length; lastEleItr++) {
            firstEleItr = lastEleItr;
        
            // Move ahead lastEleItr.. until end or not consequtive
            while ( lastEleItr + 1 < nums.length && nums[lastEleItr + 1] == nums[lastEleItr] + 1) {
                lastEleItr++;
            }
            
            if( firstEleItr == lastEleItr) {
                result.add(nums[lastEleItr] + "");
            }
            else {
                result.add(nums[firstEleItr] + "->" + nums[lastEleItr]);
            }
            
        }
        return result;
    }

}
