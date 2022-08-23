package all;

import java.util.Stack;

import all._264_LargestBSTSubtree.TreeNode;

public class _231_Tree_KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int kthSmallest(TreeNode root, int k) {
        // iterative inorder
        Stack<TreeNode> st = new Stack<>();
        int result = Integer.MAX_VALUE;
        
        while(true) {
            
            while(root != null) {
                st.push(root);
                					// root = root.right-- largest
                root = root.left; 	// all small ele  
            }
            
            // process
            root = st.pop();
            k--;
            if(k == 0) {
                return root.val;
            }
            root = root.right;	// root = root.left-- largest
        }
    }
}
