package PriorityQueue;

import java.util.PriorityQueue;

public class _67_KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findKthLargest(int[] nums, int k) {
		// put all items in priority queue
		// maintain k size.. 

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i: nums) {
			pq.add(i);
			if(pq.size() > k){
				pq.poll();
			}
		}
		return pq.poll();


	}
}
