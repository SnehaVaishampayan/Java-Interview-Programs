package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _243_Tree_HeightBalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isBalanced(TreeNode root) {
        if(root == null) {return true;}
        return getHeight(root) == -1 ? false: true;
    }
    
    public int getHeight(TreeNode node){
        if(node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
    }
    
}
