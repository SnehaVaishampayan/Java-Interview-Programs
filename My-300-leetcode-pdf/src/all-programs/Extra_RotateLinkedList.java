
public class Extra_RotateLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1->2->3->4->5->NULL
	
	// 4->5->1->2->3->NULL

	// getSize = n .. 5
	// if k = 2 .. then newHead = n-k = 5-2 = 3rd node
	//	        .. and newTail = n-k-1 = 5-2-1 = 2nd node

	// 1. Calculate size and getTailNode. 
	// 2. make circular
	// 3. newTailIndex = n - k - 1
	// 4. Iterate ptr from head till newTailIndex.. newTail = newTail.next
	// 5. newHead = newTail.next;
	// 6. break circular.. newTail.next = null

	public ListNode rotateRight(ListNode head, int k) {  
		if(head == null || head.next == null) { // edge case
			return head;
		}
		SizeAndTail nodeDetails = getSizeandTail(head); 
		int n = nodeDetails.size;

		if(n <= k){                     
			k = k % n;            
		}

		// make circular
		ListNode old_tail = nodeDetails.tail;
		old_tail.next = head;   

		// Iterate to get newTail
		int ptr = 0;
		int newTailIndex = n-k-1;

		ListNode newTail= head;        
		while(ptr != newTailIndex) {
			newTail = newTail.next;
			ptr++;
		}

		// Point newHead
		// Break Circular to Singly. 
		ListNode newHead = newTail.next;
		newTail.next = null;

		return newHead;   
	}

	private SizeAndTail getSizeandTail(ListNode head) {
		int n = 0;

		if(head == null) {
			n = 0;
		}
		if(head.next == null) {
			n = 1;
		}
		while(head.next != null){
			head = head.next;
			n++;
		}
		SizeAndTail st = new SizeAndTail(head, n+1);
		return st;
	}    
}

class SizeAndTail {
	ListNode tail;
	int size;
	public SizeAndTail(ListNode tail, int size){
		this.tail = tail;
		this.size = size;
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
