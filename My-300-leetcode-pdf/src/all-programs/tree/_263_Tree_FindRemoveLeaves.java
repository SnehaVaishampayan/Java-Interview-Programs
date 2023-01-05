package tree;

import java.util.*;

import tree._264_LargestBSTSubtree.TreeNode;

public class _263_Tree_FindRemoveLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> findLeaves(TreeNode root) {
		// if(root == null) {
		//     return 
		// res = new ArrayList<>();
		getHeight(root);
		return res;        
	}
	public int getHeight(TreeNode node) {
		if(node == null) {
			return -1;
		}

		int currNodeHeight = Math.max(getHeight(node.left) ,getHeight(node.right)) + 1;
		if(this.res.size() == currNodeHeight) {
			res.add(new ArrayList<>());
		}
		this.res.get(currNodeHeight).add(node.val);
		return currNodeHeight;
	}
}