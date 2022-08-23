package all;

import java.util.*;

public class _252_253_Tree_UniqueBSTGenerateCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> generateTrees(int n) {

		if(n==0) {
			return new ArrayList<>();
		}        

		return recursiveGenerateTree(1, n);
	}
	private List<TreeNode> recursiveGenerateTree(int start, int end) {

		List<TreeNode> allTreesResult = new ArrayList<>();

		if(start > end) {
			allTreesResult.add(null);
			return allTreesResult;
		}

		// iterating start to end
		//create left subtree
		// create right subtreee.
		// attach to currNode.. 

		for(int currNodeVal = start; currNodeVal <= end; currNodeVal++) {

			List<TreeNode> left_subTree = recursiveGenerateTree(start, currNodeVal - 1);
			List<TreeNode> right_subTree = recursiveGenerateTree(currNodeVal + 1, end);

			for(TreeNode eachLeftNode: left_subTree) {
				for(TreeNode eachRightNode: right_subTree) {
					TreeNode currNode = new TreeNode(currNodeVal);
					currNode.left = eachLeftNode;
					currNode.right = eachRightNode;
					allTreesResult.add(currNode);
				}
			}
		}
		return allTreesResult;        
	}
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for(int end = 2; end <= n; end++) {
            for(int start = 0; start < end; start++) {
                count[end] = count[end] + (count[start] * count[end - start - 1]);
            }
        }
        
        return count[n];
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
