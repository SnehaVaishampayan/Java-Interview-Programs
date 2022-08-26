package ToDo;

import java.util.*;

public class _65_66_WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class QueueWord {
		String word;
		int ladderLen;
		public QueueWord(String s, int ladderLen) {
			this.word = s;
			this.ladderLen = ladderLen;
		}
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) {
			return 0;
		}
		// ll is impl of que
		Queue<QueueWord>  que = new LinkedList<>(); 		
		que.add(new QueueWord(beginWord, 1));

		while(!que.isEmpty()) {
			QueueWord currQueWord = que.poll();
			ListIterator<String> wordListItr = wordList.listIterator();
			
			// iterate thru each word in wordlist and see if currQueWord is adjacent
			while(wordListItr.hasNext()){ 
				String currWordList = wordListItr.next();

				if(isAdjacentWord(currQueWord.word, currWordList)) {

					wordListItr.remove();
					que.add(new QueueWord(currWordList, currQueWord.ladderLen + 1));

					if(currWordList.equals(endWord))
						return currQueWord.ladderLen + 1;
				}
			}
		}
		return 0;
	}

	private boolean isAdjacentWord(String s1, String s2) {
		int diff = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i) ) {
				diff++;
				if( diff > 1) {
					return false;   
				}                
			}            
		}
		return true;
	}
}
