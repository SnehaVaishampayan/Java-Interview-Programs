package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _239_240_Tree_SortedList_SortedArry_ToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedListToBST(ListNode listHead) {
		//binary search

		if(listHead == null) {
			return null;
		}

		ListNode listMid = getMiddleOfList(listHead);

		TreeNode currNode = new TreeNode(listMid.val);

		if(listHead == listMid) { // base case
			return currNode ;
		}
		// recurse for left right
		currNode.left = sortedListToBST(listHead);
		currNode.right = sortedListToBST(listMid.next);

		return currNode;
	}

	private ListNode getMiddleOfList(ListNode head) {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		ListNode prevPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			prevPtr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;            
		}

		if(prevPtr!= null) {
			prevPtr.next = null;
		}
		return slowPtr;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;            
        }
        return recursiveBuildTree(nums, 0, nums.length-1);
    }
    
    private TreeNode recursiveBuildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = start + (end-start)/2;
        TreeNode currNode = new TreeNode(nums[mid]);

        currNode.left = recursiveBuildTree(nums, start, mid-1);
        currNode.right = recursiveBuildTree(nums, mid+1, end);

        return currNode;
    }
}
