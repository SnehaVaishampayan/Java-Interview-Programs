package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _242_Tree_MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) { return 0;}
        
        getMaxSum(root);
        return result;
    }
    
    private int getMaxSum(TreeNode node) {
        if(node == null) { return 0; }        
        
        int leftSum = Math.max(getMaxSum(node.left), 0);
        int rightSum = Math.max(getMaxSum(node.right), 0);

        int currSum = node.val + leftSum + rightSum;
        
        result = Math.max(result, currSum);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
