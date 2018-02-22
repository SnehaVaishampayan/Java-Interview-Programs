package strings;

public class RepeatedChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("ab"));
		System.out.println(repeatedSubstringPattern("abaababaab"));*/
		System.out.println(repeatedSubstringPattern("abac"));

	}
	public static boolean repeatedSubstringPattern(String s) {

	    // if odd length return false
        if(s.length()%2 != 0 ){
            return false;
        }
        int start = 0;
        int mid  = s.length()/ 2;
        int end  = s.length();
        while(start < end){
            mid = (start + end)/2;
        	System.out.println(s.substring(start,mid));
        	System.out.println(s.substring(mid,end));

            if(s.substring(start,mid).equals(s.substring(mid+1,end))){
               return true; 
            }
            else {
                end = mid;
            }
        }
        return false;
        
    }

	/*
        // traversing through the start,
        // while element doesnt repeats .. add to the sb.
        // maintain the count
        // if repeat.. stop
        // ahead of that check if the next characters same or not
        if(s.length() <= 1 || s == null){
            return true;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int pLen = 0;
        int i = 1;
        while(i < s.length() && s.charAt(i)!= s.charAt(0)) {
                sb.append(s.charAt(i));
                i++;
        }
        pLen = i;
        System.out.println(i);
        System.out.println(s.length());

        while(i < s.length()){
            if((i+pLen) > s.length() || !s.substring(i,i+pLen).equals(sb.toString())){
                return false;
            }
            i = i+pLen;
        }
        return true;
	 */
}
