package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _233_Tree_ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidBST(TreeNode root) {
        return isValidRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidRecursive(TreeNode currNode, long min, long max) {
        if(currNode == null) {
            return true;
        }
        if(min >= currNode.val || currNode.val >= max ) {
            return false;
        }
        return isValidRecursive(currNode.left, min, currNode.val) && isValidRecursive(currNode.right, currNode.val, max);
    }
}
