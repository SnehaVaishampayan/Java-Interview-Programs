package twoPtrs;


public class _35_ValidPalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome_removingSpacesDigitsNumbers(String s) {        
        
        int left = 0;	int right = s.length()-1;
        
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;        
    }
    public boolean isPalindrome_removingOneCharacter(String s) {        
        
        // traverse from both ends.. 
        // if diff && !foundDiff then foundDiff = true and remaining isPalindrome        
        int left = 0;
        int right = s.length() -1;
        boolean foundDiff = false;
        
        while(left< right) {
            if(s.charAt(left) != s.charAt(right)) {                
                if(!foundDiff) {
                    foundDiff = true;
                    if(isPalindrome(s, left+1, right)){
                        left++;
                    }
                    else if( isPalindrome(s, left, right-1)) {
                        
                        right--;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }    
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left<right){
            if(s.charAt(left) != s.charAt(right))
                return false;            
            left++;
            right--;
        }
        return true;       
    }
}
