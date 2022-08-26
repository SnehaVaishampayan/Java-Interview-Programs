package stack;
import java.util.*;

public class _33_ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String s) {
		Map<Character, Character> hm = new HashMap<>();
		hm.put('(',')');
		hm.put('{','}');
		hm.put('[',']');

        Stack<Character> st = new Stack<>();
        
        for(Character c: s.toCharArray()){
            if(hm.keySet().contains(c)) {
                st.push(c);
            }
            else { // closing brace                
                if(hm.values().contains(c)) {   // if brace in values
                    if(st.isEmpty() || hm.get(st.pop()) != c) 
                        return false;
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

}
