package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _230_Tree_InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }   
       
       // swap left - right
       TreeNode temp = root.left;
       root.left = root.right;
       root.right = temp;
       
       // go left - right
       invertTree(root.left);
       invertTree(root.right);
       return root;
   }
}
