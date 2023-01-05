package strings;
import java.util.*;

public class _18_19_20_ShortestWordDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 1. Given - listOfWords, word1, word2
	// 2. Repeated call to shortestDistance(word1, word2) .. Constructor - listOfWords
	// 3. Could be same words ..  word1 == word2
	

	
// 18_20. Given - listOfWords, word1, word2	
    public int shortestDistance_3(String[] wordsDict, String word1, String word2) {
    	
        long loc1 = Integer.MAX_VALUE;  // **** LONG for ????? 
        long loc2 = -Integer.MAX_VALUE;
        long resMinDist = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            
            if(s.equals(word1)) {
                loc1 = i;               
            } 
            if(s.equals(word2)) {                
                if (word1.equals(word2)) {	// Check requirements : if words can be same
                    loc1 = loc2;
                }
                loc2 = i;
            }
            resMinDist = Math.min(resMinDist, Math.abs(loc1-loc2));
        }
        return (int) resMinDist;    
    }
    
// 19. Repeated call to shortestDistance(word1, word2) .. Constructor - listOfWords    
    Map<String, ArrayList<Integer> > hm = new HashMap<>(); // put all the words - list of indices
    public _18_19_20_ShortestWordDistance(String[] wordsDict) {
        // this.hm = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            
            if(this.hm.containsKey(w)) {
                ArrayList<Integer> al = this.hm.get(w);//
                al.add(i);
                this.hm.put(w, al);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                this.hm.put(w, al);
            }
        }
    }
    
    public int shortestDistance_2( String word1, String word2) {
        
        ArrayList<Integer> wl1 = this.hm.get(word1);
        ArrayList<Integer> wl2 = this.hm.get(word2);
        
        int i1 = 0; int i2 = 0;
        
        int minDist = Integer.MAX_VALUE;
        
        while(i1 < wl1.size() && i2 < wl2.size()) {
            
            minDist = Math.min(minDist, Math.abs(wl1.get(i1) - wl2.get(i2)));
            
            if(wl1.get(i1) < wl2.get(i2) ) {
                i1++;
            }
            else {
                i2++;
            }
        }
        return minDist;
    }
        

    
    
}
