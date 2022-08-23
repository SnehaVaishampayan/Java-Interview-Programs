package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _262_Tree_InorderSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	TreeNode successor;
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		while(root != null) {
			if(root.val <= p.val) { // move right
				root = root.right;
			}
			else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}
}
