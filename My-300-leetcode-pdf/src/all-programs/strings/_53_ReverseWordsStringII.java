package strings;

public class _53_ReverseWordsStringII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// iterate thru the chars .. 
	// if space .. 
	//	 reverse till ptr-1.. 
	// reverse Last word
	//reverse full array
	
	public void reverseWords(char[] s) {

		int wordStart = 0;
		int wordEnd = 0;
		while(wordEnd < s.length) {
			if(s[wordEnd] == ' ') {
				reverse(s, wordStart, wordEnd-1);
				wordStart = wordEnd+1;                
			}
			wordEnd++;
		}
		reverse(s, wordStart, wordEnd-1); // last Word
		reverse(s, 0, s.length-1); // full array
	}
	private void reverse(char[] arr, int s, int e) {
		while(s<=e) {
			char temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
	}
}
