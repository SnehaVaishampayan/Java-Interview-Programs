package HashMap;

import java.util.*;

public class _42_InsertDeleteGetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Map<Integer, Integer> hm;
	List<Integer> alist;
	Random rand  =  new Random();
	/** Initialize your data structure here. */
	public _42_InsertDeleteGetRandom() {
		hm = new HashMap<Integer, Integer>();
		alist = new ArrayList<Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(hm.containsKey(val)) {
			return false;
		}

		hm.put(val, alist.size()); // val with list size.. easy to get val
		alist.add(alist.size(), val); // add at end of list given value
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!hm.containsKey(val)) {
			return false;
		}

		int eleIndex = hm.get(val);
		int lastElement = alist.get(alist.size() - 1);

		alist.set(eleIndex, lastElement); // Put last elelment at ele's index
		hm.put(lastElement, eleIndex ); // update last ele value in hm
		// delete last ele.. so given ele gets replaces with lastEle and lastEle gets deleted
		alist.remove(alist.size()-1);
		hm.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return alist.get(rand.nextInt(alist.size()));
	}
}
