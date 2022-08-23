package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _255_Tree_CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null) {
            return count;
        }
        return 1 + countNodes(root.left) + countNodes(root.right); 
    }
}
