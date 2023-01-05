package strings;

public class _16_OneEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isOneEditDistance(String s, String t) {
		int shortStrLen = s.length();
		int longStrLen = t.length();

		if(shortStrLen > longStrLen) {

			return isOneEditDistance(t, s);
		}

		if(longStrLen - shortStrLen > 1) {
			return false;
		}

		for(int i = 0; i < shortStrLen; i++) {
			if(s.charAt(i) != t.charAt(i)) {

				// if both lengths are same.. its replacement
				if(shortStrLen == longStrLen)
					return remainingStrSame(s, i + 1, t,i + 1);
				else 
					return remainingStrSame(s, i, t, i + 1);
			}
		}
		// if no diff, then for one edit away .. t should have only one char more.. 
		return shortStrLen + 1 == longStrLen;
	}

	public boolean remainingStrSame(String s, int sItr, String t, int tItr) {
		while(sItr < s.length() && tItr < t.length()) {
			if(s.charAt(sItr) != t.charAt(tItr)) {
				return false;
			}
			sItr++; tItr++;
		}
		return true;
	}
}
