package strings;

public class _56_RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isMatch_using_recursion(String s, String p) {

		if(p.length() == 0)
			return s.length() == 0;

		//p’s length 1 is special case
		if(p.length() == 1 || p.charAt(1) != '*') {			
			if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch_using_recursion(s.substring(1), p.substring(1)); // recursion

		}
		int s_ptr = -1;

		while(s_ptr < s.length() && (s_ptr < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(s_ptr))) {

			if(isMatch_using_recursion(s.substring(s_ptr+1), p.substring(2))) // recursion
				return true;
			s_ptr++;
		}
		return false;
	}


	public boolean isMatch_using_DP(String s, String p) {

		if (p == null || p.length() == 0) return (s == null || s.length() == 0);

		boolean dp[][] = new boolean[s.length()+1][p.length()+1];

		dp[0][0] = true;

		for (int p_ptr = 2; p_ptr <= p.length(); p_ptr++) 
			dp[0][p_ptr] = p.charAt(p_ptr-1) == '*' && dp[0][p_ptr-2];
		
		for (int p_ptr = 1; p_ptr <= p.length(); p_ptr++) {
			for (int s_ptr = 1; s_ptr <= s.length(); s_ptr++) {

				if (p.charAt(p_ptr-1) == s.charAt(s_ptr-1) || p.charAt(p_ptr-1) == '.') 					
					dp[s_ptr][p_ptr] = dp[s_ptr-1][p_ptr-1];

				else if(p.charAt(p_ptr-1) == '*')
					dp[s_ptr][p_ptr] =  dp[s_ptr][p_ptr-2] 
										|| ((s.charAt(s_ptr-1) == p.charAt(p_ptr-2) 
										|| p.charAt(p_ptr-2) == '.') && dp[s_ptr-1][p_ptr]); 
			}
		}
		return dp[s.length()][p.length()];
	}	        
}
