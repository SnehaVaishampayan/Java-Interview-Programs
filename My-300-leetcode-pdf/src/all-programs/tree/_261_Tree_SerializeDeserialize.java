package tree;

import java.util.*;
import java.util.Queue;

public class _261_Tree_SerializeDeserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode { 
		int val; 
		TreeNode left; 
		TreeNode right; 
		TreeNode() {} 
		public TreeNode(int val) { 
			this.val = val; 
		}
		public TreeNode(int val, TreeNode left, TreeNode right) { 
			this.val = val; 
			this.left = left; this.right = right;
		}
	}
	// traverse level order
	// aftr level add #

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		// q.offer(null);  // No null offers **********************

		while(!q.isEmpty()) {

			TreeNode curr = q.poll();

			if(curr != null) {

				//Process
				sb.append(curr.val+",");

				q.offer(curr.left);      // No null checks **********************
				q.offer(curr.right);
			}
			else {
				sb.append("#,");
				// q.offer(null);         // No null offers **********************
			}            
		}        
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0 || data.charAt(0) == '#') {
			return null;
		}
		String[] arr = data.split(",");

		// Level Order Traversal        

		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
		q.offer(root);
		int i = 1;

		while(!q.isEmpty() && i < arr.length) {
			TreeNode curr = q.poll();
			if(curr == null) {
				continue;
			}

			//populate left
			if(i < arr.length && !arr[i].equals("#") ) {             
				TreeNode leftNode = new TreeNode(Integer.valueOf(arr[i]));
				curr.left = leftNode;                
			}
			else {
				curr.left = null;
			}
			q.offer(curr.left);
			i++;

			//populate right
			if( i < arr.length && !arr[i].equals("#")) {                
				TreeNode rightNode = new TreeNode(Integer.valueOf(arr[i]));
				curr.right = rightNode;
			}
			else {
				curr.right = null;
			}
			q.offer(curr.right);
			i++;            
		}
		return root;
	}
}
