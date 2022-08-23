package all;

import all._264_LargestBSTSubtree.TreeNode;

public class _241_Tree_MinimumDepth_ShortestPathLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// minimumDepth_ShortestPathLength
	   public int minDepth(TreeNode root) {
	       
	        
	        if(root == null) {
	            return 0;
	        }
	        if(root.left == null && root.right == null) {
	            return 1;
	        }
	         int result = Integer.MAX_VALUE;
	        if(root.left != null) {
	            result = Math.min( minDepth(root.left), result);
	        }
	        if(root.right != null) {
	            result = Math.min( minDepth(root.right), result);
	        }
	        return result+1;
	               
	    }

}
