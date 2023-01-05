package tree;

import tree._264_LargestBSTSubtree.TreeNode;

public class _259_Tree_RecoverSwappedNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	TreeNode first; TreeNode second; TreeNode prev;    

	public void recoverTree(TreeNode root) {
		inorder(root);
		swapNodesVALUES(first, second);
	}

	public void inorder(TreeNode curr) {

		if(curr == null) {
			return;
		}
		inorder(curr.left);

		//process        
		if(prev == null ) {
			prev = curr;
		}
		else {                      // 1 5 8 14 19 20 .. 1 19 8 14 5 20
			if(prev.val > curr.val) { // found change
				
				if(first == null) {	 // First time change found
					first = prev;
				}
				
				second = curr;		
			}
			prev = curr;
		}

		inorder(curr.right);
	}


	public void swapNodesVALUES(TreeNode a, TreeNode b) {
		System.out.println(" a " + a.val);
		System.out.println(" b " + b.val);
		if(a!=null && b != null) {
			int temp = a.val;
			a.val = b.val;
			b.val = temp;
		}
	}
}
