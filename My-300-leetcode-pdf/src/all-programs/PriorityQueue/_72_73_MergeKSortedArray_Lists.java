package PriorityQueue;

import java.util.*;

public class _72_73_MergeKSortedArray_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		ListNode node = new ListNode();
		ListNode result = new ListNode(-1);
		ListNode resItr = result; 

		// Put all values of all lists in minHeap. 
		for(ListNode eachList : lists) {
			while(eachList != null) {
				minHeap.add(eachList.val);
				eachList = eachList.next;
			}
		}

		// Get all values from minHeap in resultList

		while(!minHeap.isEmpty()) {
			resItr.next = new ListNode(minHeap.poll());
			resItr = resItr.next;
		}
		return result.next;
	}  
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
