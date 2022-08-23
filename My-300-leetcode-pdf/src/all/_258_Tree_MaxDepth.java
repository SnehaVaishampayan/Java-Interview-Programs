package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _258_Tree_MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int result = Integer.MIN_VALUE;
        if(root.left != null) {
            result = Math.max( maxDepth(root.left), result);
        }
        if(root.right != null) {
            result = Math.max( maxDepth(root.right), result);
        }
        return result+1;
    }
}
