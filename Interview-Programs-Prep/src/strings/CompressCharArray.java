package strings;

public class CompressCharArray {
	public static void main(String[] args) {
		char[] i = {'a','a','b','b','c','c','c'};
		System.out.println(compress(i));

	}
	public static int compress(char[] chars) {   
		// cases
		if(chars == null || chars.length == 0){
			return 0;
		}
		if(chars.length == 1){
			return 1;
		}
		int backPtr = 0;
		int frontPtr = 0;
		// travverse array from start
		// if char change count the steps and pu in backptr
		while(frontPtr < chars.length){
			char c = chars[frontPtr];
			int count=0;
			while(frontPtr < chars.length && chars[frontPtr] == c){
				frontPtr++;
				count++;
			}
			chars[backPtr] = c;
			backPtr++;
			if(count != 1) // if not array out of bound abbbbbbbbbbbbb
				for(char n: Integer.toString(count).toCharArray()){
					chars[backPtr] = n;
					backPtr++;
				}
		}
		if(backPtr <= chars.length){
			return backPtr;
		}
		else{
			return chars.length;
		}
	}
}