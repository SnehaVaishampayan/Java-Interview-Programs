package tree;

import tree._264_LargestBSTSubtree.TreeNode;

public class _254_Tree_SumRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    int result = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        recGetSum(root, 0);
        return result;
    }
    
    private void recGetSum(TreeNode node, int currNum) {
        if(node == null) {
            return;
        }
        currNum = currNum * 10 + node.val;
        if(node.left == null && node.right == null) {
            result += currNum;
        }
        recGetSum(node.left, currNum);
        recGetSum(node.right, currNum);
    }
}
