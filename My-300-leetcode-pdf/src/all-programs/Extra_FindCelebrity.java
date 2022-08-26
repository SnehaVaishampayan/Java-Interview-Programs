
public class Extra_FindCelebrity {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findCelebrity(int n) {
		// assume 0 as celeb
		// if itr knows celeb.. celeb = itr 
		//     celeb = itr .. 

		// again iterating
		// if celeb not itr(skip) and celeb know itr .. OR itr do not knows celeb.. 

		int celeb = 0;

		for(int i = 1; i < n; i++) {
			if(knows(celeb, i )) {
				celeb = i;
			}
		}

		for(int i = 0; i < n; i++) {
			if( (i != celeb && knows(celeb, i))  || !knows(i, celeb)) {
				return -1;
			}
		}
		return celeb;

	}

	private boolean knows(int a, int b) {
		// Implementation - Given method
		return true;
	}

}
