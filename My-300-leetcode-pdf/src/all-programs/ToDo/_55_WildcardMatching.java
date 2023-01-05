package ToDo;


public class _55_WildcardMatching {
	
	// *********** HARD
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// *********** HARD
	public boolean isMatch_using_Pointers(String str, String pattern) {
		int str_ptr = 0, ptn_ptr = 0, match = 0, star_index = -1;            
		while (str_ptr < str.length()){
			// advancing both pointers
			if (ptn_ptr < pattern.length()  && (pattern.charAt(ptn_ptr) == '?' || str.charAt(str_ptr) == pattern.charAt(ptn_ptr))){
				str_ptr++;
				ptn_ptr++;
			}
			// * found, only advancing pattern pointer
			else if (ptn_ptr < pattern.length() && pattern.charAt(ptn_ptr) == '*'){
				star_index = ptn_ptr;
				match = str_ptr;
				ptn_ptr++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (star_index != -1){
				ptn_ptr = star_index + 1;
				match++;
				str_ptr = match;
			}   
			//current pattern pointer is not star, last patter pointer was not *
			//characters do not match
			else return false;            
		}
		return false;
	}


	public boolean isMatch_using_DP(String s, String p) {
		
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		
		dp[s.length()][p.length()] = true;
		
		for(int i=p.length()-1;i>=0;i--){
			
			if(p.charAt(i) != '*')				
				break;
			else				
				dp[s.length()][i] = true;
		}
		for(int i=s.length()-1; i >= 0; i--) {
			
			for(int j = p.length()-1; j >= 0; j--) {
				
				if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
					dp[i][j]=dp[i+1][j+1];
				
				else if(p.charAt(j)=='*')
					dp[i][j]=dp[i+1][j]||dp[i][j+1];
				
				else
					dp[i][j]=false;
			}
		}
		return dp[0][0];
	}
	// *****************	COMPARE WITH  ***************************************
	// _56_RegularExpressionMatching *************************************************************** 
	public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);
        
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        
        dp[0][0] = true;
        
        for (int j=2; j<=p.length(); j++) {
        	
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
        }
        
        for (int j=1; j<=p.length(); j++) {
            for (int i=1; i<=s.length(); i++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
					dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }
        }
        return dp[s.length()][p.length()];
    }	
}
