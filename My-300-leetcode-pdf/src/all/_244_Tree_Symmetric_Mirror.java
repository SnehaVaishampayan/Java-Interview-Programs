package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _244_Tree_Symmetric_Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSymmetric(TreeNode root) {
        if(root == null) { return true;}
    
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null) { return true; }
        
        if( a == null || b == null) { return false; }

        if(a.val != b.val) { return false; }
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

}
