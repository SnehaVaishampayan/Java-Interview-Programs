package tree;

import java.util.*;

import tree._264_LargestBSTSubtree.TreeNode;

public class _237_238_Tree_ConstructFrom_Pre_Post_Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] preorder;
	int[] inorder;
	int prePtr = 0;
	Map<Integer, Integer> hm;
	
	// **************	PREORDER - INORDER

	public TreeNode buildTreePREorder(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;

		this.hm = new HashMap<>();
		populateInorderInHashMap();

		return recursiveBuildFromPREORDER(0, inorder.length);

	}

	private TreeNode recursiveBuildFromPREORDER(int inStart, int inEnd) {
		if(inStart == inEnd) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[prePtr]);
		prePtr++;

		int in_index = hm.get(preorder[prePtr]);
		node.left = recursiveBuildFromPREORDER(inStart, in_index);
		node.right = recursiveBuildFromPREORDER(in_index+1, inEnd);

		return node;
	}

	// **************	POSTORDER - INORDER
	int[] postorder;
//	int[] inorder;
//	Map<Integer, Integer> hm;
	int postPtr;

	public TreeNode buildTreePOSTorder(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;
		this.postPtr = postorder.length - 1; 		// ****** from right

		this.hm = new HashMap<>();
		populateInorderInHashMap();
		return recursiveBuildFromPostOrder(0, inorder.length-1); 

	}

	private TreeNode recursiveBuildFromPostOrder(int start, int end) {
		if(start > end) { 
			return null;
		}
		int in_index = hm.get(postorder[postPtr]); 	
		TreeNode newNode = new TreeNode(postorder[postPtr]);
		postPtr--;						// ****** move right.. 

		newNode.right = recursiveBuildFromPostOrder(in_index + 1, end);  // ****** populate Right side first      
		newNode.left = recursiveBuildFromPostOrder(start,in_index-1 );
		return newNode;
	}

	private void populateInorderInHashMap() {		
		for(int i =0 ; i < this.inorder.length; i++) { // assuming unique elements. 
			if(!hm.containsKey(this.inorder[i])) {
				hm.put(this.inorder[i], i);
			}
		}
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
}
