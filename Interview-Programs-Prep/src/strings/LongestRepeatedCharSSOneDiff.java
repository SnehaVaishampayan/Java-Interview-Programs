package strings;

public class LongestRepeatedCharSSOneDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
		public int maxRepOpt1(String text) {
			if(text == null || text.length() <= 1) {
				return text.length();
			}
			// substring with <= 1 char different 
			// if count of > 0 ? len .. else -1
			int[] charCount = new int[26];

			for(char c: text.toCharArray()) {
				charCount[(int)c-97]++;
			}
			
			if(text.length() <= 1) {
				return text.length();
			}
			int start = 0; int end = 1;
			char selCh = text.charAt(0);

			// add eaaaaaa
			boolean diffFound= false;
			int result = 1;
			while(end < text.length()) {
				
				System.out.println(" sel " + selCh);

				if(end - start == 1) {
					System.out.println(" 1" );
					if(text.charAt(start) == text.charAt(end)) {

						System.out.println(" 2" );

						selCh = text.charAt(start);                    
					}
					else {
						System.out.println("3" );

						if (end+1 < text.length()) {
							System.out.println("4 " );
							selCh = text.charAt(start) == text.charAt(end+1)? text.charAt(start): text.charAt(end) ;
							diffFound = true;
						}
						else {
							System.out.println("5" );
							return result;
						}
					}


				}
				else {
					System.out.println("6" );
					if(text.charAt(end) != selCh) {
						System.out.println("7" );
						if(diffFound) {
							return result;
						}
						result = Math.max(result, end-start+1); 
					}

				}
				System.out.println(" end " + text.charAt(end));
				end++;
				// b = 1 a = 1 .. if charNotInStore .. move start.. if anotherCount > 1

			}

			System.out.println(" sel " + selCh);
			return result-1;
		}
	}
}