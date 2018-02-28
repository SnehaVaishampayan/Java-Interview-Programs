package strings;

public class Decrypt {

	static String decrypt(String word) {
		// null validation.. zero length validatio
		// return null or "";

		// Get the Asci value of each char
		// subtrat from prev calue
		// add 26 till more than 97
		if(word == null){
			return null;
		}
		if(word.length() == 0){
			return "";
		}
		StringBuilder result = new StringBuilder();
		int prev = 1;//Character.getNumericValue(word.charAt(0));

		for(int i = 0; i < word.length();i++){
			int curr = (int)word.charAt(i);//Character.getNumericValue(word.charAt(i));
			System.out.println("curr " + curr);
			int diff = curr - prev;
			//System.out.println(" diff " + diff);

			while(diff < 97){
				diff += 26;  
			}
			// ascci to char - get char 
			char c = (char) diff;
			System.out.println(" diff " + diff);
			result.append(c);
			prev = curr;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(decrypt("dnotq"));
	}

}