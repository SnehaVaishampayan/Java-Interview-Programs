package tree;

import java.util.*;

import tree._264_LargestBSTSubtree.TreeNode;

public class _245_Tree_BST_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Stack<TreeNode> st;
	public _245_Tree_BST_Iterator(TreeNode root) {
		st = new Stack<>();
		while(root!= null) {    // push all left nodes
			st.push(root);
			root = root.left;
		}
	}

	public int next() {
		TreeNode currNode = st.pop(); // next val keep in result
		int result = currNode.val;

		if(currNode.right!= null) { // push all RIGHT's left
			currNode = currNode.right;
			while(currNode!= null) {
				st.push(currNode);
				currNode = currNode.left;
			}
		}
		return result;
	}

	public boolean hasNext() {
		return !st.isEmpty();
	}

}
