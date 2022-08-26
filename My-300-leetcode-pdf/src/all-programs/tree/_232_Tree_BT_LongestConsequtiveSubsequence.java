package tree;

import tree._264_LargestBSTSubtree.TreeNode;

public class _232_Tree_BT_LongestConsequtiveSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }
    
    private int dfs(TreeNode currNode, TreeNode parent, int currLen){
        if(currNode == null) {
            return 0;
        }
        currLen = (parent != null && currNode.val == parent.val + 1) ? currLen+1 : 1 ;
        return Math.max(currLen ,  
                        Math.max(dfs(currNode.left, currNode, currLen) , dfs(currNode.right, currNode, currLen)));
    }
}
