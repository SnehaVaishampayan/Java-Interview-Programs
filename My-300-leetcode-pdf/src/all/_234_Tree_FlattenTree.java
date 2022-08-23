package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _234_Tree_FlattenTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    TreeNode parent = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        // Reverse preorder.. 

        flatten(root.right);
        flatten(root.left);
        
        root.right = parent;
        root.left = null;
        parent = root;
    }
}
