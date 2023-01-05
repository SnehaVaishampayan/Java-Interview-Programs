package tree;

import java.util.*;

import tree._264_LargestBSTSubtree.TreeNode;

public class _257_Tree_AllPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> binaryTreePaths(TreeNode root) {

		List<List<String>> res = new ArrayList<>();

		dfs(root, res, new ArrayList<>());   

		List<String> finalResult = getInFormat(res);        
		return finalResult;
	}

	public void dfs(TreeNode currNode, List<List<String>> res, List<String> subResult) {
		subResult.add(String.valueOf(currNode.val));
		if(currNode.left == null && currNode.right == null) {
			res.add(subResult);
			return;
		}
		if(currNode.left != null) {
			dfs(currNode.left, res, new ArrayList<>(subResult));    
		}
		if(currNode.right != null) {
			dfs(currNode.right, res, new ArrayList<>(subResult));
		}

	}

	public List<String> getInFormat(List<List<String>> res) {
		List<String> finalResult = new ArrayList<>();
		for(List<String> eachList: res) {
			StringBuilder sb = new StringBuilder();
			sb.append(eachList.get(0));
			for(int i = 1; i < eachList.size(); i++) {
				sb.append("->");
				sb.append(eachList.get(i));
			}
			finalResult.add(sb.toString());
		}
		return finalResult;
	}
}
