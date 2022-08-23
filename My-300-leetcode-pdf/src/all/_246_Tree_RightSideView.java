package all;

import java.util.*;

import all._264_LargestBSTSubtree.TreeNode;

public class _246_Tree_RightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if(root == null) {
			return res;
		}
		//Level order traversal
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()) {

			int currSize = q.size();

			for(int i = 0; i < currSize; i++) {
				TreeNode currNode = q.poll();
				if(i==currSize-1)    {
					res.add(currNode.val);
				}

				if(currNode.left != null) {
					q.offer(currNode.left);
				}
				if(currNode.right != null) {
					q.offer(currNode.right);
				}
			}
		}
		return res;
	}

}
